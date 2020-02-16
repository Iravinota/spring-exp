package com.ws.exp.spring.mybatis;

import com.ws.exp.spring.mybatis.mapper.CoffeeMapper;
import com.ws.exp.spring.mybatis.model.Coffee;
import com.ws.exp.spring.mybatis.model.CoffeeExample;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Application
 *
 * @author Eric at 2020-02-16_17:40
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.ws.exp.spring.mybatis.mapper")
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
        generateArtifacts(); // mybatis自动生成
        // playWithArtifacts();
    }

    private void generateArtifacts() throws Exception {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                this.getClass().getResourceAsStream("/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    private void playWithArtifacts() {
        Coffee espresso = new Coffee()
                .withName("espresso")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(espresso);

        Coffee latte = new Coffee()
                .withName("latte")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(latte);

        Coffee s = coffeeMapper.selectByPrimaryKey(1L);
        log.info(">>> Coffee {}", s);

        CoffeeExample example = new CoffeeExample();
        example.createCriteria().andNameEqualTo("latte");
        List<Coffee> list = coffeeMapper.selectByExample(example);
        list.forEach(e -> log.info(">>> selectByExample: {}", e));
    }
}
