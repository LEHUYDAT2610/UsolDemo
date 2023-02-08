package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Product> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody Product newProduct){
        return ResponseEntity.ok(service.save(newProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product,@PathVariable Long id){
        return ResponseEntity.ok(service.update(product, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
