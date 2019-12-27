package com.ws.experiment.spring.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MainDBTest
 *
 * @author Eric at 2019-12-27_15:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/db/datasource.xml"})
public class MainDBTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDB() {
        Assert.assertNotNull(jdbcTemplate);
    }
}
