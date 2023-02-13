package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.models.dto.ProductDto;
import com.company.UsolDemo.repository.BrandRepository;
import com.company.UsolDemo.repository.CategoryRepository;
import com.company.UsolDemo.service.BrandService;
import com.company.UsolDemo.service.CategoryService;
import com.company.UsolDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
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

    @PostMapping(value = "/add")
    public ResponseEntity<?> insert(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(service.save(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductDto productDto,@PathVariable Long id){
        return ResponseEntity.ok(service.update(productDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
