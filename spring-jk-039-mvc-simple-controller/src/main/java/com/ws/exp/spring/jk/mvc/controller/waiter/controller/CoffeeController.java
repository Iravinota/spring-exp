package com.ws.exp.spring.jk.mvc.controller.waiter.controller;

import com.ws.exp.spring.jk.mvc.controller.waiter.model.Coffee;
import com.ws.exp.spring.jk.mvc.controller.waiter.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/")
    @ResponseBody       // List<Coffee>直接作为返回结果。@ResponseBody和@Controller可以合并成@RestController
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }
}
