package com.ws.exp.spring.jk.redis.service;

import com.ws.exp.spring.jk.redis.model.Coffee;
import com.ws.exp.spring.jk.redis.model.CoffeeOrder;
import com.ws.exp.spring.jk.redis.model.OrderState;
import com.ws.exp.spring.jk.redis.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CoffeeOrderService
 *
 * @author Eric at 2020-02-17_11:28
 */
@Slf4j
@Service
@Transactional
public class CoffeeOrderService {
    private CoffeeOrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(CoffeeOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CoffeeOrder createOrder(String customer, Coffee... coffees) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info(">>> New Order: {}", saved);
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn(">>> Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info(">>> Updated Order: {}", order);
        return true;
    }
}
