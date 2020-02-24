package com.ws.exp.spring.jk.springbucks.service;

import com.ws.exp.spring.jk.springbucks.model.Coffee;
import com.ws.exp.spring.jk.springbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * CoffeeService
 *
 * @author Eric at 2020-02-17_11:22
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "coffee")
public class CoffeeService {
    private CoffeeRepository coffeeRepository;

    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Cacheable
    public List<Coffee> findAllCoffee() {
        return coffeeRepository.findAll();
    }

    @CacheEvict
    public void reloadCoffee() {
    }

    public Optional<Coffee> findOneCoffee(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase());
        Optional<Coffee> coffee = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(), matcher));
        log.info(">>> Coffee found: {}", coffee);
        return coffee;
    }
}
