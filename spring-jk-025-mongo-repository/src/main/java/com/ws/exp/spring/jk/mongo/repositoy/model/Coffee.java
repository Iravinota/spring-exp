package com.ws.exp.spring.jk.mongo.repositoy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Coffee: 和spring-jk-025-mongo相比没有变化
 *
 * @author Eric at 2020-02-18_15:42
 */
@Document   // 和@Entity类似，用来标识这个类对应的是哪一个文档
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {
    @Id     // mongodb中每个文档对应一个id
    private String id;  // 注意这个Id需要是String
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
