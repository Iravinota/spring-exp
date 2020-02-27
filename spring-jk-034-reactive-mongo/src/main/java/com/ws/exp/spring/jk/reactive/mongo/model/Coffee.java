package com.ws.exp.spring.jk.reactive.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * Coffee
 *
 * @author Eric at 2020-02-27_20:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private String id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
