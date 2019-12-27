package com.ws.experiment.springmvc.pojo;

import org.springframework.stereotype.Component;

/**
 * User
 *
 * @author Eric at 2019-12-27_18:14
 */
@Component
public class User {
    private String name;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
