package com.ws.exp.spring.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * CoffeeOrder
 *
 * @author Eric at 2020-02-14_20:23
 */
@Entity
@Table(name = "T_ORDER")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity implements Serializable {

    private String customer;

    @ManyToMany     // 咖啡和订单是Many to Many关系
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;

    @Enumerated     // 使用枚举做映射
    @Column(nullable = false)
    private OrderState state;
}
