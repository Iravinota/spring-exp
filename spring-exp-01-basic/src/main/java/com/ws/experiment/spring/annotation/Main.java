package com.ws.experiment.spring.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Main
 *
 * @author Eric at 2019-12-26_16:31
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Teacher teacher = context.getBean(Teacher.class);
        logger.info(teacher.toString());

        context.close();
    }
}
