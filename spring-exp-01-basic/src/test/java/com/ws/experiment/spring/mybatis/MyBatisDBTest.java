package com.ws.experiment.spring.mybatis;

import com.ws.experiment.spring.basic.User;
import com.ws.experiment.spring.mybatis.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * MyBatisDBTest
 *
 * @author Eric at 2019-12-27_15:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/db/db-mybatis-transaction.xml"})
public class MyBatisDBTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao() {
        Assert.assertNotNull(userDao);
        List<User> users = userDao.getAllUsers();
        System.out.println(users);
        Assert.assertEquals(2, users.size());
        Assert.assertEquals("Jerry", users.get(0).getName());
        Assert.assertEquals("Beijing", users.get(0).getAddr());
        Assert.assertEquals("Angel", users.get(1).getName());
        Assert.assertEquals("Shanghai", users.get(1).getAddr());
    }
}
