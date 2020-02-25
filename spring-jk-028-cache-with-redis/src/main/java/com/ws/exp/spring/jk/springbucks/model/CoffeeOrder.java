package com.ws.exp.spring.jk.springbucks.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * CoffeeOrder
 *
 * @author Eric at 2020-02-17_11:12
 */
@Entity
@Table(name = "T_ORDER")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder extends BaseEntity implements Serializable {

    // 为什么没有注解？
    private String customer;

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")  // 这有什么用
    private List<Coffee> items;

    @Enumerated
    @Column(nullable = false)   // 为什么会有Column注解，为什么其它没有
    private OrderState state;
}
