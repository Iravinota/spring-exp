package com.ws.exp.spring.jk.aspect.service;

import com.ws.exp.spring.jk.aspect.model.Coffee;
import com.ws.exp.spring.jk.aspect.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CoffeeService
 *
 * @author Eric at 2020-02-17_11:22
 */
@Slf4j
@Service
public class CoffeeService {
    private CoffeeRepository coffeeRepository;

    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
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
