package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    public ResponseEntity<ResponseObject> saveBrand(Brand brand);
    public ResponseEntity<ResponseObject> getAll();
    public ResponseEntity<ResponseObject> findById(Long id);
    public ResponseEntity<ResponseObject> update(Brand newBrand,Long id);
    public ResponseEntity<ResponseObject> delete(Long id);
}
