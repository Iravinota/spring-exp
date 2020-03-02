package com.ws.exp.spring.jk.context.hierarchy.foo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * FooAspect
 *
 * @author Eric at 2020-03-02_20:14
 */
@Aspect
@Slf4j
public class FooAspect {

    @AfterReturning("bean(testBean*)")  // 在bean testBean*执行完之后，AOP执行这里的代码
    public void printAfter() {
        log.info(">>> after hello()");
    }
}
