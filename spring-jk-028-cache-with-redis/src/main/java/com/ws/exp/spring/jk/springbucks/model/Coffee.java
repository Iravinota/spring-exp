package com.ws.exp.spring.jk.springbucks.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Coffee
 *
 * @author Eric at 2020-02-17_11:08
 */
@Entity
@Table(name = "T_COFFEE")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee extends BaseEntity implements Serializable {

    private String name;

    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;
}
