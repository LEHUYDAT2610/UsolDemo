package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceIml implements CategoryService{
    @Autowired
    private CategoryRepository repo;
    @Override
    public Category saveCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }
}
