package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/add")
    public String add(@RequestBody Category category){
        service.saveCategory(category);
        return "New Category added!";
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return service.getAll();
    }
}
