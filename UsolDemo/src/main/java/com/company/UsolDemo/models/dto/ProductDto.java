package com.company.UsolDemo.models.dto;

import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productID;
    private String productName;
    private double price;
    private String productDecription;
    private double discount;
    private MultipartFile image;
    private Date productCreated;
    private Brand brand;
    private Category category;
}
