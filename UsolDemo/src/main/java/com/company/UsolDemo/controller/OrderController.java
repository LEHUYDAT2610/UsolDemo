package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Order;
import com.company.UsolDemo.models.dto.OrderDTO;
import com.company.UsolDemo.service.AccountService;
import com.company.UsolDemo.service.OrderService;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin
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
    public ResponseEntity<?> update(@RequestParam("orderStatus") int orderStatus,@PathVariable Long id){
        return ResponseEntity.ok(service.update(orderStatus, id));
    }

    @GetMapping ("/getallorder")
    public ResponseEntity<?> GetAllOrder(){
        try {
            List<OrderDTO> productDTOS=service.GetOrder();
            return  ResponseEntity.ok(productDTOS);
        }catch (Exception ex){
            Map<String,String> errorMessage = new HashMap<>();
            errorMessage.put("devMsg", ex.getMessage());
            errorMessage.put("userMsg","Có lỗi xẩy ra vui lòng liên hệ Dat 09 để được hỗ trợ!");
            return ResponseEntity.status(500).body(errorMessage);
        }
    }
    @PostMapping ("/updateorder")
    public ResponseEntity<?> UpdateOrder(@RequestParam long id){
        try {
            service.UpdateOrder(id);
            return  ResponseEntity.ok(200);
        }catch (Exception ex){
            Map<String,String> errorMessage = new HashMap<>();
            errorMessage.put("devMsg", ex.getMessage());
            errorMessage.put("userMsg","Có lỗi xẩy ra vui lòng liên hệ Dat 09 để được hỗ trợ!");
            return ResponseEntity.status(500).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
