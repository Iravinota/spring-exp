package com.ws.exp.spring.model;

import lombok.*;
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
@ToString(callSuper = true) // 调用父类的ToString
@NoArgsConstructor  // lombok自动设置无参构造函数
@AllArgsConstructor // lombok自动设置全参构造函数
public class Coffee extends BaseEntity implements Serializable {

    private String name;

    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
          parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;
}
