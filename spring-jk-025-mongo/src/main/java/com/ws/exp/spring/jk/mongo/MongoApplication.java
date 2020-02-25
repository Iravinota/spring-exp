package com.ws.exp.spring.jk.mongo;

import com.mongodb.client.result.UpdateResult;
import com.ws.exp.spring.jk.mongo.converter.MoneyReadConverter;
import com.ws.exp.spring.jk.mongo.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * MongoApplication
 *
 * @author Eric at 2020-02-18_16:10
 */
@SpringBootApplication
@Slf4j
public class MongoApplication implements ApplicationRunner {
    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    // org.springframework.boot:spring-boot-autoconfigure:2.2.2.RELEASE# org.springframework.boot.autoconfigure.data.mongo
    // 里面用到了MongoCustomConversions，如果没有手动配置，就会自动生成一个默认的配置
    // 这里自定义了Money和Document的转换方法
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(new Date())
                .updateTime(new Date()).build();
        Coffee saved = mongoTemplate.save(espresso);
        log.info(">>> Saved Coffee: {}", saved);

        List<Coffee> list = mongoTemplate.find(
                Query.query(Criteria.where("name").is("espresso")), // 构造查询条件
                Coffee.class);
        log.info(">>> Find {} Coffee", list.size());
        list.forEach(coffee -> log.info(">>> Finded Coffee: {}", coffee));

        Thread.sleep(1000); // 为了查看更新时间，延迟一秒
        UpdateResult result = mongoTemplate.updateFirst(
                Query.query(Criteria.where("name").is("espresso")),
                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30)).currentDate("updateTime"), // currentDate()更新updateTime
                Coffee.class);
        log.info(">>> Update Result: {}", result.getModifiedCount());
        Coffee updateOne = mongoTemplate.findById(saved.getId(), Coffee.class);
        log.info(">>> Update Result: {}", updateOne);

        mongoTemplate.remove(updateOne);
    }
}
