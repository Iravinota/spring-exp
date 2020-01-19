package com.ws.experiment.springboot.druid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * DruidDemoApplication
 *
 * @author Eric
 * @create 2020-01-02_22:33
 */

@SpringBootApplication
@Slf4j
public class DruidDemoApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DruidDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>>>>" + dataSource.toString());
    }
}
