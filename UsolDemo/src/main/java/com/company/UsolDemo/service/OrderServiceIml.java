package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.exception.OrderNotFoundException;
import com.company.UsolDemo.models.Order;
import com.company.UsolDemo.models.dto.OrderDTO;
import com.company.UsolDemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public Order update(int orderStatus, Long id) {
        return repo.findById(id)
                .map(order -> {
                    order.setOrderStatus(orderStatus);
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

    @Override
    public List<OrderDTO> GetOrder() {
        List<OrderDTO> orderDTOList=repo.GetOrder().stream().map((value)->{
            String username=(String) value[0];
            Date orderDate=(Date) value[1];
            Integer status=(Integer) value[2];
            return new OrderDTO(username,orderDate,status);
        }).collect(Collectors.toList());
        return  orderDTOList;
    }

    @Override
    public void UpdateOrder(long id) {
        repo.UpdateOrder(id);
    }
}
