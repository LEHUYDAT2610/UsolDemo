package com.company.UsolDemo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(name = "ProductName")
    private String productName;
    @Column(name = "ProductPrice")

    private double price;
    @Column(name = "ProductDescription")

    private String productDecription;
    @Column(name = "Discount")
    private double discount;
    @Column(name = "Image")
    private String image;
    @Column(name = "ProductCreated")
    private Date productCreated;

    // Many to One Có nhiều người ở 1 địa điểm.
    @ManyToOne
    @JoinColumn(name = "BrandID") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "CategoryID") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;
}
