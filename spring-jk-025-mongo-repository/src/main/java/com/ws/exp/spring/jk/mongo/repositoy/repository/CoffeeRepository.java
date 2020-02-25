package com.ws.exp.spring.jk.mongo.repositoy.repository;

import com.ws.exp.spring.jk.mongo.repositoy.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * CoffeeRepository
 *
 * @author Eric at 2020-02-18_20:44
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {
    List<Coffee> findByName(String name);
}
