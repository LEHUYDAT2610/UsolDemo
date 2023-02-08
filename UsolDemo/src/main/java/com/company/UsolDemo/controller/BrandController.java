package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.dto.BrandDto;
import com.company.UsolDemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
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

    @PostMapping(value = "/add",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestParam("brandName") String brandName,
                                    @RequestParam("brandImage") MultipartFile brandImage) {
        BrandDto brandDto = new BrandDto();
        brandDto.setBrandName(brandName);
        brandDto.setBrandImage(brandImage);
        return ResponseEntity.ok(service.save(brandDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestParam("name") String brandName,
                                    @RequestParam("brandImage") MultipartFile brandImage,
                                    @PathVariable Long id) {
        BrandDto brandDto = new BrandDto();
        brandDto.setBrandName(brandName);
        brandDto.setBrandImage(brandImage);
        return ResponseEntity.ok(service.update(brandDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
