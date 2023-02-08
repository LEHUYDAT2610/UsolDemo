package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.dto.AccountDto;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    List<Account> getAll();
    Account findById(Long id);
    Account update(Account account,Long id);
    String delete(Long id);
}
