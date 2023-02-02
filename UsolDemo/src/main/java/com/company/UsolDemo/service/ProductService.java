package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAll();
}
