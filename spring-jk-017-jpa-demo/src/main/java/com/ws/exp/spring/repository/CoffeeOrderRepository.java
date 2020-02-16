package com.ws.exp.spring.repository;

import com.ws.exp.spring.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * CoffeeOrderRepository
 *
 * @author Eric at 2020-02-14_20:29
 */
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {  // Id是Long
}
