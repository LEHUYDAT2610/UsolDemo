package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Order;

import java.util.List;

public interface OrderService {
    public Order saveOrder(Order order);
    public List<Order> getAll();
}
