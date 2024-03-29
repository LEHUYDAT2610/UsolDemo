package com.company.UsolDemo.models.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {
    private String productName;
    private Date orderDate;
    private String status;
    private int orderQuaity;
    private double price;
    private double total;
}
