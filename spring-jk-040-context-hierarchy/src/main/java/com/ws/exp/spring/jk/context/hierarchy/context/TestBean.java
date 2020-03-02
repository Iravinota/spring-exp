package com.ws.exp.spring.jk.context.hierarchy.context;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TestBean
 *
 * @author Eric at 2020-03-02_20:09
 */
@AllArgsConstructor
@Slf4j
public class TestBean {
    private String context;

    public void hello() {
        log.info(">>> hello " + context);
    }
}
