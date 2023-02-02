package com.company.UsolDemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRatingKey  implements Serializable {
    @Column(name = "order_ID")
    Long order_ID;

    @Column(name = "product_ID")
    Long product_ID;
}
