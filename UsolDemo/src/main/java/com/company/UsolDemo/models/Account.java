package com.company.UsolDemo.models;

import com.company.UsolDemo.models.dto.AccountDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "Account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;
    @Column(name = "UserName")
    private String userName;

    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Password")

    private String password;
    @Column(name = "Address")

    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Image")
    private String accountImage;
    @Column(name = "Status")
    private int accountStatus;
    @Column(name = "Role")
    private int accountRole;

//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<Order> orders;

    public Account(AccountDto accountDto) {
        this.accountID = accountDto.getAccountID();
        this.userName = accountDto.getUserName();
        this.fullName = accountDto.getFullName();
        this.address = accountDto.getAddress();
        this.phone = accountDto.getPhone();
        this.email = accountDto.getEmail();
    }

    public Account(String password) {
        this.password = password;
    }

    public Account(String userName, String fullName, String password, String address, String phone, String email, int accountStatus, int accountRole) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.accountStatus = accountStatus;
        this.accountRole = accountRole;
    }
}
