package com.company.UsolDemo.models.dto;

import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private long oderId;
    private Date orderDate;
    private int orderStatus;
    private long accountId;
}
