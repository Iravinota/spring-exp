package com.ws.exp.spring.mybatis.pagehelper;

import com.github.pagehelper.PageInfo;
import com.ws.exp.spring.mybatis.pagehelper.mapper.CoffeeMapper;
import com.ws.exp.spring.mybatis.pagehelper.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * com.ws.exp.spring.mybatis.pagehelper.Applicaion
 *
 * @author Eric at 2020-02-17_10:24
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.ws.exp.spring.mybatis.pagehelper.mapper")
public class PageHelperDemoApplicaion implements ApplicationRunner {

    private CoffeeMapper coffeeMapper;

    @Autowired
    public void setCoffeeMapper(CoffeeMapper coffeeMapper) {
        this.coffeeMapper = coffeeMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(PageHelperDemoApplicaion.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))
                .forEach(c -> log.info(">>> Page(1) Coffee {}", c));
        coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))
                .forEach(c -> log.info(">>> Page(2) Coffee {}", c));

        log.info(">>> =====================");

        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(c -> log.info(">>> Page(1) Coffee {}", c));

        log.info(">>> =====================");

        coffeeMapper.findAllWithParam(1, 3)
                .forEach(c -> log.info(">>> Page(1) Coffee {}", c));
        List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
        PageInfo page = new PageInfo(list);
        log.info(">>> PageInfo: {}", page);
    }
}
