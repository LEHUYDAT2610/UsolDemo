package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public String add(@RequestBody Product product){
        service.saveProduct(product);
        return "New Product Added!";
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return service.getAll();
    }
}
