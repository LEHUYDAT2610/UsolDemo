package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Order;
import com.company.UsolDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("/add")
    public String add(@RequestBody Order order){
        service.saveOrder(order);
        return "New Order added!";
    }
    @GetMapping("/getAll")
    public List<Order> getAll(){
        return service.getAll();
    }
}
