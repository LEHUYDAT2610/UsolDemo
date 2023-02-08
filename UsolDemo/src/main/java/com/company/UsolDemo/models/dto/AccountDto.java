package com.company.UsolDemo.models.dto;

import com.company.UsolDemo.models.Account;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long accountID;
    private String userName;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private MultipartFile accountImage;
    private int accountRole;
    private int accountStatus;
}
