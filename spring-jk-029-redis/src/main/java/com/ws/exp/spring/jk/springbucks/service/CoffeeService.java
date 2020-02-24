package com.ws.exp.spring.jk.springbucks.service;

import com.ws.exp.spring.jk.springbucks.model.Coffee;
import com.ws.exp.spring.jk.springbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * CoffeeService
 *
 * @author Eric at 2020-02-17_11:22
 */
@Slf4j
@Service
public class CoffeeService {
    private static final String CACHE = "springbucks-coffee";
    @Autowired
    private CoffeeRepository coffeeRepository;
    // key:String, value:Coffee
    @Autowired
    private RedisTemplate<String, Coffee> redisTemplate;

    public List<Coffee> findAllCoffee() {
        return coffeeRepository.findAll();
    }

    // RedisTemplate对redis缓存进行操作
    public Optional<Coffee> findOneCoffee(String name) {
        // 查找之前先去redis看一看
        HashOperations<String, String, Coffee> hashOperations = redisTemplate.opsForHash();
        if (redisTemplate.hasKey(CACHE) && hashOperations.hasKey(CACHE, name)) {
            log.info(">>> >>> Get coffee {} from Redis.", name);
            return Optional.of(hashOperations.get(CACHE, name));
        }

        // 没有缓存
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Coffee> coffee = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(), matcher));
        log.info(">>> >>> Coffee Found: {}", coffee);
        if (coffee.isPresent()) {
            log.info(">>> >>> Put coffee {} to Redis.", name);
            hashOperations.put(CACHE, name, coffee.get());
            redisTemplate.expire(CACHE, 1, TimeUnit.MINUTES);   // 对redis的操作一定要设置过期时间
        }
        return coffee;
    }
}
