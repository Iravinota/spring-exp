package com.ws.exp.spring.jk.mongo.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * MoneyReadConverter: 这里设置了Money和mongodb中的文档记录之间如何进行转换
 *
 * Money到Document的转换是自动序列化成json格式的
 *
 * @author Eric at 2020-02-18_15:57
 */
public class MoneyReadConverter implements Converter<Document, Money> {
    @Override
    public Money convert(Document source) {
        Document money = (Document)source.get("money");
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document)money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
