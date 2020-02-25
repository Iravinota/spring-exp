package com.ws.exp.spring.jk.springbucks;

import com.ws.exp.spring.jk.springbucks.model.Coffee;
import com.ws.exp.spring.jk.springbucks.model.CoffeeOrder;
import com.ws.exp.spring.jk.springbucks.model.OrderState;
import com.ws.exp.spring.jk.springbucks.repository.CoffeeRepository;
import com.ws.exp.spring.jk.springbucks.service.CoffeeOrderService;
import com.ws.exp.spring.jk.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

/**
 * SpringBucksApplication
 *
 * @author Eric at 2020-02-17_11:36
 */
@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringBucksApplication implements ApplicationRunner {
    private CoffeeRepository coffeeRepository;
    private CoffeeService coffeeService;
    private CoffeeOrderService orderService;

    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Autowired
    public void setCoffeeService(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Autowired
    public void setOrderService(CoffeeOrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(">>> All Coffee: {}", coffeeRepository.findAll());

        Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
        if (latte.isPresent()) {
            CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
            log.info(">>> Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
            log.info(">>> Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
        }
    }
}
