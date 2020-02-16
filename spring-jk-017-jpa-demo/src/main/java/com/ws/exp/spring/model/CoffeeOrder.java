package com.ws.exp.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * CoffeeOrder
 *
 * @author Eric at 2020-02-14_20:23
 */
@Entity
@Table(name = "T_ORDER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder implements Serializable {

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)不使用sequence，使用H2数据库的自增
    private Long id;

    private String customer;

    @ManyToMany     // 咖啡和订单是Many to Many关系
    @JoinTable(name = "T_ORDER_COFFEE")
    private List<Coffee> items;

    @Column(nullable = false)
    private Integer state;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
}
