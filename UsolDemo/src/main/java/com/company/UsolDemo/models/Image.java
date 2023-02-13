package com.company.UsolDemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageID;
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "productid")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;
}
