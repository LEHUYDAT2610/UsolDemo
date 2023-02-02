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
    private Long product_ID;

    @Column(name = "Product_Name")
    private String product_Name;
    @Column(name = "Product_Price")

    private double price;
    @Column(name = "Product-Description")

    private String product_Decription;
    @Column(name = "Discount")

    private double discount;
    @Column(name = "Image_Link")
    private String Image_link;
    @Column(name = "Image")
    private String Image;
    @Column(name = "Product_Created")
    private Date product_Created;
    @Column(name = "View")
    private int view;

    // Many to One Có nhiều người ở 1 địa điểm.
    @ManyToOne
    @JoinColumn(name = "brand_ID") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_ID") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;
}
