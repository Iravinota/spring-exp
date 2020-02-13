package com.ws.exp.spring.jk.simplejdbc;

import lombok.Builder;
import lombok.Data;

/**
 * pojo
 *
 * @author Eric at 2020-01-21_22:30
 */
@Data       // 自动设置setter, getter
@Builder    // 自动设置一个builder
public class Foo {
    private Long id;
    private String bar;
}
