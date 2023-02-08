package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Product;

import java.util.List;

public interface ProductService {
    Product save(Product newProduct);
    List<Product> getAll();
    Product findById(Long id);
    Product update(Product newProduct,Long id);
    String delete(Long id);
}
