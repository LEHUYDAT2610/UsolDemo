package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category newCategory);
    List<Category> getAll();
    Category findById(Long id);
    Category update(Category newCategory,Long id);
    String delete(Long id);
}
