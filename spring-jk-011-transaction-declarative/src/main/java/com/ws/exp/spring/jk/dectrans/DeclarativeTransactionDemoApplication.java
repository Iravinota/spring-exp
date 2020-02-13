package com.ws.exp.spring.jk.dectrans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 声明式事务：使用注解方式的事务
 *
 * @author Eric at 2020-02-13_17:05
 */
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)   // 以注解方式开启事务。mode这里指明AOP方式使用JDK动态代理，而不是AspectJ
@Slf4j
public class DeclarativeTransactionDemoApplication implements CommandLineRunner {
    private FooService fooService;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setFooService(FooService fooService) {
        this.fooService = fooService;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DeclarativeTransactionDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fooService.insertRecord();
        log.info(">>> AAA {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));

        try {
            fooService.insertThenRollback();
        } catch (Exception ex) {
            log.info(">>> BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }

        try {
            fooService.invokeInsertThenRollback();
        } catch (Exception ex) {
            log.info(">>> BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }
    }
}
