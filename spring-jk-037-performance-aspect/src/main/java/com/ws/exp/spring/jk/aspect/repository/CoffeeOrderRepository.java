package com.ws.exp.spring.jk.aspect.repository;

import com.ws.exp.spring.jk.aspect.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CoffeeOrderRepository
 *
 * @author Eric at 2020-02-17_11:20
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
