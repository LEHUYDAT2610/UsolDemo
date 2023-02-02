package com.company.UsolDemo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "OrderProduct")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_ID;

    @Column(name = "Order_Date")
    private Date order_Date;
    @Column(name = "Order_Status")
    private int order_Status;

    @ManyToOne
    @JoinColumn(name = "account_ID") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Account account;

}
