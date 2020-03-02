package com.ws.exp.spring.jk.mvc.controller.waiter.repository;

import com.ws.exp.spring.jk.mvc.controller.waiter.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
