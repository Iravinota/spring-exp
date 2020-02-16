package com.ws.exp.spring.repository;

import com.ws.exp.spring.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * CoffeeRepository
 *
 * @author Eric at 2020-02-14_20:31
 */
public interface CoffeeRepository extends BaseRepository<Coffee, Long> {
}
