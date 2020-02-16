package com.ws.exp.spring;

import com.ws.exp.spring.model.Coffee;
import com.ws.exp.spring.model.CoffeeOrder;
import com.ws.exp.spring.model.OrderState;
import com.ws.exp.spring.repository.CoffeeOrderRepository;
import com.ws.exp.spring.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Application
 *
 * @author Eric at 2020-02-14_20:26
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@Slf4j
public class Application implements ApplicationRunner {

    private CoffeeRepository coffeeRepository;
    private CoffeeOrderRepository orderRepository;

    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Autowired
    public void setOrderRepository(CoffeeOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional  // 开启事务
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
        findOrders();
    }

    private void initOrders() {
        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info(">>> Coffee: {}", espresso);

        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info(">>> Coffee: {}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(OrderState.INIT)
                .build();
        orderRepository.save(order);
        log.info(">>> Order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(espresso, latte))
                .state(OrderState.INIT)
                .build();
        orderRepository.save(order);
        log.info(">>> Order: {}", order);
    }

    private void findOrders() {
        coffeeRepository
                .findAll(Sort.by(Sort.Direction.DESC, "id"))
                .forEach(c -> log.info(">>> Loading {}", c));
        List<CoffeeOrder> list = orderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info(">>> findTop3ByOrderByUpdateTimeDescIdAsc: {}", getJoinedOrderId(list));

        list = orderRepository.findByCustomerOrderById("Li Lei");
        log.info(">>> findByCustomerOrderById: {}", getJoinedOrderId(list));

        // 不开启事务会因为没Session而报LazyInitializationException
        list.forEach(o -> {
            log.info(">>> Order {}", o.getId());
            o.getItems().forEach(i -> log.info(">>>   Item {}", i));
        });

        list = orderRepository.findByItems_Name("latte");
        log.info(">>> findByItems_Name: {}", getJoinedOrderId(list));
    }

    private String getJoinedOrderId(List<CoffeeOrder> list) {
        return list.stream().map(o -> o.getId().toString())
                .collect(Collectors.joining(","));
    }
}
