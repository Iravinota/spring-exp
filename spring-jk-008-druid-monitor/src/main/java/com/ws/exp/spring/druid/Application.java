package com.ws.exp.spring.druid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Application
 *
 * @author Eric at 2020-02-14_13:36
 */
@SpringBootApplication
@Slf4j
@EnableTransactionManagement(proxyTargetClass = true)
public class Application implements CommandLineRunner {
    private DataSource dataSource;
    private FooService fooService;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setFooService(FooService fooService) {
        this.fooService = fooService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>" + dataSource.toString());
        new Thread(() -> fooService.selectForUpdate()).start();
        new Thread(() -> fooService.selectForUpdate()).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}
    }
}
