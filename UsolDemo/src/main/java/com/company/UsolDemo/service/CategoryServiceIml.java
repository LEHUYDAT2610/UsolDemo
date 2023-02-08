package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.exception.CategoryNotFoundException;
import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.repository.BrandRepository;
import com.company.UsolDemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceIml implements CategoryService{
    @Autowired
    private CategoryRepository repo;

    @Override
    public Category save(Category newCategory) {
        return repo.save(newCategory);
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new CategoryNotFoundException(id));
    }

    @Override
    public Category update(Category newCategory, Long id) {
        return repo.findById(id)
                .map(category -> {
                    category.setCategoryName(newCategory.getCategoryName());
                    category.setCategoryImage(newCategory.getCategoryImage());
                    return repo.save(category);
                }).orElseThrow(()->new CategoryNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if(!repo.existsById(id)){
            throw new CategoryNotFoundException(id);
        }
        repo.deleteById(id);
        return "Order with id "+ id +" id has been deleted success!";
    }
}
