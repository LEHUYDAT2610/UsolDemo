package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.ResponseObject;
import com.company.UsolDemo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceIml implements BrandService{
    @Autowired
    private BrandRepository repo;

    @Override
    public ResponseEntity<ResponseObject> saveBrand(Brand brand) {
        List<Brand> foundBrands = repo.findByBrandName(brand.getBrandName().trim());
        return foundBrands.size()>0?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("Failed","Brand name already taken","")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Insert brand successfully",repo.save(brand))
                );
    }

    @Override
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Querry brand success!",repo.findAll())
        );
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Brand> foundBrand = repo.findById(id);
        return foundBrand.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Query brand successfully!",foundBrand)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed","Cannot find brand with id = "+id,"")
                );
    }

    @Override
    public ResponseEntity<ResponseObject> update(Brand newBrand, Long id) {
        Brand updateBrand = repo.findById(id)
                .map(brand -> {
                    brand.setBrandName(newBrand.getBrandName());
                    brand.setBrandImage(newBrand.getBrandImage());
                    brand.setProducts(newBrand.getProducts());
                    return repo.save(brand);
                }).orElseGet(()->{
                    newBrand.setBrandId(id);
                    return repo.save(newBrand);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update brand successfully",updateBrand)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> delete(Long id) {
        boolean exists = repo.existsById(id);
        if(exists){
            repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Delete brand successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed","Cannot find brand id to delete"," ")
        );
    }

}
