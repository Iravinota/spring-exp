package com.ws.exp.spring.mybatis;

import com.ws.exp.spring.mybatis.mapper.CoffeeMapper;
import com.ws.exp.spring.mybatis.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 *
 * @author Eric at 2020-02-16_14:46
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.ws.exp.spring.mybatis.mapper") // 扫描的mapper目录
public class Application implements ApplicationRunner {

    private CoffeeMapper coffeeMapper;

    @Autowired
    public void setCoffeeMapper(CoffeeMapper coffeeMapper) {
        this.coffeeMapper = coffeeMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee c = Coffee.builder().name("espresso").price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        int count = coffeeMapper.save(c);
        log.info(">>> Save {} Coffee: {}", count, c);

        c = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0)).build();
        count = coffeeMapper.save(c);
        log.info(">>> Save {} Coffee: {}", count, c);

        c = coffeeMapper.findById(c.getId());
        log.info(">>> Find Coffee: {}", c);
    }
}
