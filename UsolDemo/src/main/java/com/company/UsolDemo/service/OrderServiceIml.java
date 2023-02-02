package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Order;
import com.company.UsolDemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceIml implements OrderService{
    @Autowired
    private OrderRepository repo;
    @Override
    public Order saveOrder(Order order) {
        Date date = new Date();
        order.setOrder_Date(date);
        return repo.save(order);
    }

    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }
}
