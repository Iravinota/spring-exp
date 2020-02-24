package com.ws.exp.spring.jk.springbucks;

import com.ws.exp.spring.jk.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBucksApplication
 *
 * @author Eric at 2020-02-17_11:36
 */
@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories
@EnableCaching(proxyTargetClass = true)
public class SpringBucksApplication implements ApplicationRunner {
    private CoffeeService coffeeService;

    @Autowired
    public void setCoffeeService(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(">>> Count: {}", coffeeService.findAllCoffee().size());    // 真查数据库，会在日志中打印出Hibernate的SQL
        for (int i = 0; i < 10; i++) {
            log.info(">>> Reading from cache.");
            coffeeService.findAllCoffee();      // 不再查数据库，日志中不会打印Hibernate的SQL
        }
        coffeeService.reloadCoffee();
        log.info(">>> Reading after refresh.");
        coffeeService.findAllCoffee().forEach(c -> log.info(">>> Coffee {}", c.getName())); // findAllCoffee()又会重新查数据库，日志中会打印出Hibernate的SQL
    }
}
