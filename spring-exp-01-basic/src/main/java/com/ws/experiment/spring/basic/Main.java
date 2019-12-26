package com.ws.experiment.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main
 *
 * @author Eric at 2019-12-25_18:26
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-basic.xml");
        String str = context.getBean("name", String.class);
        logger.info(str);
//        System.out.println(str);

        User user = context.getBean("user", User.class);
//        System.out.println(user);
        logger.info(user.toString());

        context.close();
    }
}
