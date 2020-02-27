package com.ws.exp.spring.jk.reactive.mongo.converter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * MoneyReadConverter
 *
 * @author Eric at 2020-02-27_20:55
 */
public class MoneyReadConverter implements Converter<Long, Money> {
    @Override
    public Money convert(Long aLong) {
        return Money.ofMinor(CurrencyUnit.of("CNY"), aLong);
    }
}
