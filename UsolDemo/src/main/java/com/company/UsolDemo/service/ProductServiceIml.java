package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.exception.CategoryNotFoundException;
import com.company.UsolDemo.exception.ProductNotFoundException;
import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.repository.BrandRepository;
import com.company.UsolDemo.repository.CategoryRepository;
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
    public Product save(Product newProduct) {
        return repo.save(newProduct);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
    }

    @Override
    public Product update(Product newProduct, Long id) {
        return repo.findById(id)
                .map(product -> {
                    product.setProductCreated(newProduct.getProductCreated());
                    product.setProductDecription(newProduct.getProductDecription());
                    product.setProductName(newProduct.getProductName());
                    product.setBrand(newProduct.getBrand());
                    product.setCategory(newProduct.getCategory());
                    product.setDiscount(newProduct.getDiscount());
                    product.setPrice(newProduct.getPrice());
                    product.setImages(newProduct.getImages());
                    return repo.save(product);
                }).orElseThrow(()->new BrandNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if(!repo.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        repo.deleteById(id);
        return "Product with id "+ id +" id has been deleted success!";
    }
}
