package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceIml implements ProductService{

    @Autowired
    private ProductRepository repo;
    @Override
    public Product saveProduct(Product product) {
        Date date = new Date();
        product.setProduct_Created(date);
        return repo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }
}
