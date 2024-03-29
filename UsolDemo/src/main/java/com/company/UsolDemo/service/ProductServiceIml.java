package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.exception.CategoryNotFoundException;
import com.company.UsolDemo.exception.ProductNotFoundException;
import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;
import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.models.dto.BrandDto;
import com.company.UsolDemo.models.dto.ProductDto;
import com.company.UsolDemo.repository.BrandRepository;
import com.company.UsolDemo.repository.CategoryRepository;
import com.company.UsolDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class ProductServiceIml implements ProductService{
    @Autowired
    private ProductRepository repo;

    @Override
    public Product save(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductDecription(productDto.getProductDecription());
        product.setPrice(productDto.getPrice());
        product.setDiscount(productDto.getDiscount());
        product.setBrand(productDto.getBrand());
        product.setCategory(productDto.getCategory());
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        product.setProductCreated(date);
        getImageFromDto(productDto,product);
        return repo.save(product);
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
    public Product update(ProductDto productDto, Long id) {
        return repo.findById(id)
                .map(product -> {
                    product.setProductCreated(productDto.getProductCreated());
                    product.setProductDecription(productDto.getProductDecription());
                    product.setProductName(productDto.getProductName());
                    product.setBrand(productDto.getBrand());
                    product.setCategory(productDto.getCategory());
                    product.setDiscount(productDto.getDiscount());
                    product.setPrice(productDto.getPrice());
                    if(productDto.getProductImage() != null){
                        getImageFromDto(productDto,product);
                    }
                    return repo.save(product);
                }).orElseThrow(()->new ProductNotFoundException(id));
    }

    private static void getImageFromDto(ProductDto productDto, Product product) {
        MultipartFile image = productDto.getProductImage();
        Path path = Paths.get("uploads/product");
        if (image.isEmpty()) {
            product.setProductImage("default.jpg");
        }
        try {
            InputStream inputStream = image.getInputStream();
            Files.copy(inputStream, path.resolve(image.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setProductImage(image.getOriginalFilename().toLowerCase());
        } catch (Exception ex) {

        }
    }

    @Override
    public String delete(Long id) {
        if(!repo.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        repo.deleteById(id);
        return "Product with id "+ id +" id has been deleted success!";
    }

    @Override
    public List<Product> getAllByName(String name) {
        List<Product> productList=repo.findByProductName(name);
        if(productList==null){

        }
        return productList;
    }
}
