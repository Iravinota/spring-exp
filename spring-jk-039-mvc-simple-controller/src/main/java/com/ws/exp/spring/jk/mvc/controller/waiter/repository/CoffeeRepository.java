package com.ws.exp.spring.jk.mvc.controller.waiter.repository;

import com.ws.exp.spring.jk.mvc.controller.waiter.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    List<Coffee> findByNameInOrderById(List<String> list);
}
