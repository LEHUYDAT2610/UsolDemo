package com.company.UsolDemo.models.dto;

import com.company.UsolDemo.models.Account;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private Long account_ID;
    private String userName;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private String account_Image;
    private int account_Role;
    private int account_Status;

    public AccountDto() {
    }

    public AccountDto(Account account) {
        this.account_ID = account.getAccount_ID();
        this.userName = account.getUserName();
        this.fullname = account.getFullname();
        this.address = account.getAddress();
        this.phone = account.getPhone();
        this.email = account.getEmail();
        this.account_Image = account.getAccount_Image();
        this.account_Role = 1;
        this.account_Status = 1;
    }
}
