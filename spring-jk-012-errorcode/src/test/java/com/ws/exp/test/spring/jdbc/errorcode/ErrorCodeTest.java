package com.ws.exp.test.spring.jdbc.errorcode;

import com.ws.exp.spring.jdbc.errorcode.CustomDuplicatedKeyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ErrorCodeTest
 *
 * @author Eric at 2020-02-13_20:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.ws.exp.spring.jdbc.errorcode.Application.class)
public class ErrorCodeTest {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test(expected = CustomDuplicatedKeyException.class)
    public void testThrowingCustomException() {
        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
    }

}
