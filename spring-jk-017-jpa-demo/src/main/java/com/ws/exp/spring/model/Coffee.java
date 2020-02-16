package com.ws.exp.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Coffee类是一个实体，对应T_MENU表，其中有5个属性<br/>
 * id: 主键，自动生成<br/>
 * name: 普通属性<br/>
 * price: 与数据库字段映射，存储到数据库中的类型是PersistentMoneyAmount指定的类型<br/>
 * createTime: 插入数据时，自动添加一个时间戳<br/>
 * updateTime: 更新数据时，自动添加一个时间戳
 *
 * @author Eric at 2020-02-14_19:33
 */
@Entity
@Table(name = "T_MENU")
@Builder    // lombok自动创建这个类的builder
@Data       // lombok自动设置@Setter @Getter @ToString
@NoArgsConstructor  // lombok自动设置无参构造函数
@AllArgsConstructor // lombok自动设置全参构造函数
public class Coffee implements Serializable {

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)不使用sequence，使用H2数据库的自增
    private Long id;

    private String name;

    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount", // 告知数据库中存储哪种类型
          parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;

    @Column(updatable = false)  // 不可修改
    @CreationTimestamp  // 创建时间戳。当执行插入操作时，自动向数据库中插入一个时间戳
    private Date createTime;

    @UpdateTimestamp    // 更新时间戳。当执行更新操作时，自动向数据库中插入一个时间戳
    private Date updateTime;
}
