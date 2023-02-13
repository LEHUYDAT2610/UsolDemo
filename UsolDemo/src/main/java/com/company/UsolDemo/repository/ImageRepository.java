package com.company.UsolDemo.repository;

import com.company.UsolDemo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findByProductProductID(long id);

}
