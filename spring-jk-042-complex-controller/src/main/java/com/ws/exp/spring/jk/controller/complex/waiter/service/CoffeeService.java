package com.ws.exp.spring.jk.controller.complex.waiter.service;

import com.ws.exp.spring.jk.controller.complex.waiter.model.Coffee;
import com.ws.exp.spring.jk.controller.complex.waiter.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Cacheable  // 缓存
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll(Sort.by("id"));
    }

    public List<Coffee> getCoffeeByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }

    public Coffee getCoffee(Long id) {
        return coffeeRepository.getOne(id);
    }

    public Coffee getCoffee(String name) {
        return coffeeRepository.findByName(name);
    }

}
