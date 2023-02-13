package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.dto.BrandDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BrandService {
    Brand save(BrandDto brandDto);
    List<Brand> getAll();
    Brand findById(Long id);
    Brand update(BrandDto brandDto,Long id);
    String delete(Long id);
}
