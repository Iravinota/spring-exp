package com.ws.experiment.spring.annotation;

import com.ws.experiment.spring.basic.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 以annotation方式开发的Spring
 *
 * @author Eric at 2019-12-26_16:02
 */
@Configuration
@ComponentScan(basePackages = {"com.ws.experiment.spring.annotation"})
public class SpringConfig {

    @Bean
    public String str() {
        return "A String";
    }

    @Bean("id")
    public String id() {
        return "Good";
    }

    @Bean("title")
    public String title() {
        return "Dr.";
    }

    @Bean
    public User user() {
        User user = new User();
        user.setName("AAA");
        user.setAddr("BBB");
        return user;
    }
}
