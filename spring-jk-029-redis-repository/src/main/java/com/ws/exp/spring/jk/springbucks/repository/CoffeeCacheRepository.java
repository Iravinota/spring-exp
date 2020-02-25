package com.ws.exp.spring.jk.springbucks.repository;

import com.ws.exp.spring.jk.springbucks.model.CoffeeCache;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * CoffeeCacheRepository
 *
 * @author Eric at 2020-02-24_22:33
 */
public interface CoffeeCacheRepository extends CrudRepository<CoffeeCache, Long> {
    Optional<CoffeeCache> findOneByName(String name);
}
