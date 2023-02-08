package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.service.BrandService;
import com.company.UsolDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Category> categories = service.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Category category = service.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody Category newCategory){
        return ResponseEntity.ok(service.save(newCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Category category,@PathVariable Long id){
        return ResponseEntity.ok(service.update(category, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
