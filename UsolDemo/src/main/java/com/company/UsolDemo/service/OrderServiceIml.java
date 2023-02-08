package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.exception.OrderNotFoundException;
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
    public Order save(Order newOrder) {
        return repo.save(newOrder);
    }

    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }

    @Override
    public Order findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new OrderNotFoundException(id));
    }

    @Override
    public Order update(Order newOrder, Long id) {
        return repo.findById(id)
                .map(order -> {
                    order.setOrderDate(newOrder.getOrderDate());
                    order.setOrderStatus(newOrder.getOrderStatus());
                    order.setAccount(newOrder.getAccount());
                    return repo.save(order);
                }).orElseThrow(()->new OrderNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if(!repo.existsById(id)){
            throw new OrderNotFoundException(id);
        }
        repo.deleteById(id);
        return "Order with id "+ id +" id has been deleted success!";
    }
}
