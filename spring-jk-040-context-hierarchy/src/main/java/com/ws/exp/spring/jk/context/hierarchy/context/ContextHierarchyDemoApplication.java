package com.ws.exp.spring.jk.context.hierarchy.context;

import com.ws.exp.spring.jk.context.hierarchy.foo.FooConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ContextHierarchyDemoApplication
 *
 * @author Eric at 2020-03-02_20:17
 */
@SpringBootApplication
@Slf4j
public class ContextHierarchyDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ContextHierarchyDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // fooContext是根据FooConfig.class配置的；barContext是根据applicationContext.xml配置的
        // forContext是barContext的父亲
        ApplicationContext fooContext = new AnnotationConfigApplicationContext(FooConfig.class);
        ClassPathXmlApplicationContext barContext = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}
                , fooContext
        );

        TestBean bean = fooContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        log.info("==================");

        bean = barContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        bean = barContext.getBean("testBeanY", TestBean.class);
        bean.hello();
    }
}
