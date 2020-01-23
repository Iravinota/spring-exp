package com.ws.exp.spring.jk.simplejdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * SimpleJdbcApplication
 *
 * @author Eric at 2020-01-21_22:34
 */
@SpringBootApplication
@Slf4j  // lombok注解，自动使用slf4j日志
public class SimpleJdbcApplication implements CommandLineRunner {

    private FooDao fooDao;

    @Autowired
    public void setFooDao(FooDao fooDao) {
        this.fooDao = fooDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleJdbcApplication.class, args);
    }

    @Bean       // simpleJdbcInsert
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate).withTableName("FOO").usingGeneratedKeyColumns("ID");
    }

    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void run(String... args) throws Exception {
        fooDao.insertData();
        fooDao.listData();
    }
}
