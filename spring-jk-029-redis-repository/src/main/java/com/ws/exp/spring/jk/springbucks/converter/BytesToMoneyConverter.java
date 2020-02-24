package com.ws.exp.spring.jk.springbucks.converter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.nio.charset.StandardCharsets;

/**
 * BytesToMoneyConverter
 *
 * @author Eric at 2020-02-24_22:39
 */
@ReadingConverter   // 读取时的转换器。从Redis中读取数据时，把byte[]转换为Money
public class BytesToMoneyConverter implements Converter<byte[], Money> {
    @Override
    public Money convert(byte[] source) {
        String value = new String(source, StandardCharsets.UTF_8);
        return Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(value));
    }
}
