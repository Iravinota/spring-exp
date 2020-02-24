package com.ws.exp.spring.jk.springbucks.repository;

import com.ws.exp.spring.jk.springbucks.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CoffeeRepository
 *
 * @author Eric at 2020-02-17_11:21
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
