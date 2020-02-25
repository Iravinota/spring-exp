package com.ws.exp.spring.jk.mongo.repositoy;

import com.ws.exp.spring.jk.mongo.repositoy.converter.MoneyReadConverter;
import com.ws.exp.spring.jk.mongo.repositoy.model.Coffee;
import com.ws.exp.spring.jk.mongo.repositoy.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Date;

/**
 * MongoApplication
 *
 * @author Eric at 2020-02-18_16:10
 */
@SpringBootApplication
@Slf4j
@EnableMongoRepositories    // 添加了这个注解
public class MongoRepositoryApplication implements CommandLineRunner {
    private CoffeeRepository coffeeRepository;

    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoRepositoryApplication.class, args);
    }

    // org.springframework.boot:spring-boot-autoconfigure:2.2.2.RELEASE# org.springframework.boot.autoconfigure.data.mongo
    // 里面用到了MongoCustomConversions，如果没有手动配置，就会自动生成一个默认的配置
    // 这里自定义了Money和Document的转换方法
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

    @Override
    public void run(String... args) throws Exception {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(new Date())
                .updateTime(new Date()).build();
        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .createTime(new Date())
                .updateTime(new Date()).build();

        coffeeRepository.insert(Arrays.asList(espresso, latte));
        coffeeRepository.findAll(Sort.by("name"))
                .forEach(c -> log.info(">>> Saved Coffee {}", c));

        Thread.sleep(1000);
        latte.setPrice(Money.of(CurrencyUnit.of("CNY"), 35.0));
        latte.setUpdateTime(new Date());
        coffeeRepository.save(latte);
        coffeeRepository.findByName("latte")
                .forEach(c -> log.info(">>> Coffee {}", c));

        coffeeRepository.deleteAll();
    }
}
