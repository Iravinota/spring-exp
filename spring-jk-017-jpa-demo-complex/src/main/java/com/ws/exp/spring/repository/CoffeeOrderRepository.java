package com.ws.exp.spring.repository;

import com.ws.exp.spring.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * CoffeeOrderRepository
 *
 * @author Eric at 2020-02-14_20:29
 */
public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByCustomerOrderById(String customer);
    List<CoffeeOrder> findByItems_Name(String name);
}
