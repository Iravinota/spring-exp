package com.ws.exp.spring.jk.reactive.mongo.converter;

import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * MoneyWriteConverter
 *
 * @author Eric at 2020-02-27_20:56
 */
public class MoneyWriteConverter implements Converter<Money, Long> {
    @Override
    public Long convert(Money money) {
        return money.getAmountMinorLong();
    }
}
