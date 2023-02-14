package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.dto.AccountDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    void Registration(Account account);
    Account UpdateAccount(long id,AccountDto accountDto);
    List<Account> getAll();
    Account update(Account account,Long id);
    String delete(Long id);
    Account ChangePassword(long id,Account accountDto);

    //Admin
    //thay doi quyen cho account
    Account UpdateAccountAd(long id, Account account,MultipartFile image);
    String SendPassword(String email);
    void DeleteAccunt(long id);

}
