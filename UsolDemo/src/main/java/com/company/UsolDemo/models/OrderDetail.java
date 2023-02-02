package com.company.UsolDemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private CourseRatingKey id;

    @Column(name = "Order_Quantity")
    private int order_Quantity;
    @Column(name = "Order_Amuont")
    private double order_Amuont;

    @ManyToOne
    @MapsId("order_ID")
    @JoinColumn(name = "order_ID")
    private Order order;

    @ManyToOne
    @MapsId("product_ID")
    @JoinColumn(name = "product_ID")
    private Product product;
}
