package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    Order save(Order newOrder);
    List<Order> getAll();
    Order findById(Long id);
    Order update(Order newOrder,Long id);
    String delete(Long id);
}
