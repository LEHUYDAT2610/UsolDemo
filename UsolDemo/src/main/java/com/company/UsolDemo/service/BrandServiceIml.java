package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceIml implements BrandService{
    @Autowired
    private BrandRepository repo;

    @Override
    public Brand saveBrand(Brand newBrand) {
        return repo.save(newBrand);
    }

    @Override
    public List<Brand> getAll() {
        return repo.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new BrandNotFoundException(id));
    }

    @Override
    public Brand update(Brand newBrand, Long id) {
        return repo.findById(id)
                .map(brand -> {
                    brand.setBrandName(newBrand.getBrandName());
                    brand.setBrandImage(newBrand.getBrandImage());
                    brand.setProducts(newBrand.getProducts());
                    return repo.save(brand);
                }).orElseThrow(()->new BrandNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if(!repo.existsById(id)){
            throw new BrandNotFoundException(id);
        }
        repo.deleteById(id);
        return "User with id "+ id +" id has been deleted success!";
    }

}
