package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Brand> brands = service.getAll();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Brand brand = service.findById(id);
        return ResponseEntity.ok(brand);
    }

    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody Brand newBrand){
        return ResponseEntity.ok(service.saveBrand(newBrand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Brand brand,@PathVariable Long id){
        return ResponseEntity.ok(service.update(brand, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
