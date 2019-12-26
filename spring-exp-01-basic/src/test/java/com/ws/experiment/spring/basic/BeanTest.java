package com.ws.experiment.spring.basic;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * BeanTest
 *
 * @author Eric at 2019-12-25_19:10
 */
public class BeanTest extends SpringTestBase {

    /*属性值从spring/spring-basic.xml中注入*/
    @Autowired
    private String strrrr;

    /*属性值从spring/spring-basic.xml中注入*/
    @Autowired
    private User user;

    @Test
    public void testStr() {
        assertEquals("Tom", strrrr);
    }

    @Test
    public void testUser() {
        assertNotNull(user);
        System.out.println(user);
        assertEquals("Tom", user.getName());
        assertEquals("Some Addr", user.getAddr());
    }
}
