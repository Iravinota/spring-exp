package com.ws.exp.spring.jk.controller.complex.waiter.repository;

import com.ws.exp.spring.jk.controller.complex.waiter.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
