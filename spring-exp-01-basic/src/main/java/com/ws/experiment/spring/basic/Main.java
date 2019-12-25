package com.ws.experiment.spring.basic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main
 *
 * @author Eric
 * @create 2019-12-25_18:26
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-basic.xml");
        String str = context.getBean("name", String.class);
        System.out.println(str);

        User user = context.getBean("user", User.class);
        System.out.println(user);

        context.close();
    }
}
