package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    Brand saveBrand(Brand newBrand);
    List<Brand> getAll();
    Brand findById(Long id);
    Brand update(Brand newBrand,Long id);
    String delete(Long id);
}
