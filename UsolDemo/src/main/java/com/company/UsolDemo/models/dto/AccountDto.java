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
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String accountImage;
    private int accountRole;
    private int accountStatus;

    public AccountDto() {
    }

    public AccountDto(Account account) {
        this.account_ID = account.getAccountID();
        this.userName = account.getUserName();
        this.fullName = account.getFullName();
        this.address = account.getAddress();
        this.phone = account.getPhone();
        this.email = account.getEmail();
        this.accountImage = account.getAccountImage();
        this.accountRole = 1;
        this.accountStatus = 1;
    }
}
