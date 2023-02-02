package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.dto.AccountDto;

import java.util.List;

public interface AccountService {
    public Account saveAccount(Account account);
    public List<AccountDto> getAll();
}
