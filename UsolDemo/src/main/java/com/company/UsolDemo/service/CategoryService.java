package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAll();
}
