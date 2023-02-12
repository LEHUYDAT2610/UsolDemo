package com.company.UsolDemo.models.dto;

import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String userName;
    private Date orderDate;
    private int orderStatus;
}
