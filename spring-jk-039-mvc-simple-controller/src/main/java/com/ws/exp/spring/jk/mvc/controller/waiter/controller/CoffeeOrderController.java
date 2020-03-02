package com.ws.exp.spring.jk.mvc.controller.waiter.controller;

import com.ws.exp.spring.jk.mvc.controller.waiter.controller.request.NewOrderRequest;
import com.ws.exp.spring.jk.mvc.controller.waiter.model.Coffee;
import com.ws.exp.spring.jk.mvc.controller.waiter.model.CoffeeOrder;
import com.ws.exp.spring.jk.mvc.controller.waiter.service.CoffeeOrderService;
import com.ws.exp.spring.jk.mvc.controller.waiter.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {
    @Autowired
    private CoffeeOrderService orderService;
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[] {});
        return orderService.createOrder(newOrder.getCustomer(), coffeeList);
    }
}
