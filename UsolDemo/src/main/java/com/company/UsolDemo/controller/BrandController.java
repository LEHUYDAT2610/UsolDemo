package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.ResponseObject;
import com.company.UsolDemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService service;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> insert(@RequestBody Brand brand){
        return service.saveBrand(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@RequestBody Brand brand,@PathVariable Long id){
        return service.update(brand,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
