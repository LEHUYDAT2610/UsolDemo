package com.company.UsolDemo.models;

import com.company.UsolDemo.models.dto.AccountDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long account_ID;
    @Column(name = "Username")
    private String userName;

    @Column(name = "FullName")
    private String fullname;
    @Column(name = "Password")

    private String password;
    @Column(name = "Address")

    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Image")
    private String account_Image;
    @Column(name = "Status")
    private int account_Status;
    @Column(name = "Role")
    private int account_Role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Order> orders;

    public Account(AccountDto accountDto) {
        this.account_ID = accountDto.getAccount_ID();
        this.userName = accountDto.getUserName();
        this.fullname = accountDto.getFullname();
        this.address = accountDto.getAddress();
        this.phone = accountDto.getPhone();
        this.email = accountDto.getEmail();
        this.account_Image = accountDto.getAccount_Image();
    }
}
