package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Order;
import com.company.UsolDemo.service.AccountService;
import com.company.UsolDemo.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private AccountService accountService;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Order> orders = service.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Order order = service.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/add/{accountID}")
    public ResponseEntity<?> insert(@RequestBody Order newOrder){
        return ResponseEntity.ok(service.save(newOrder));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order,@PathVariable Long id){
        return ResponseEntity.ok(service.update(order, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
