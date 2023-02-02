package com.company.UsolDemo.service;

import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.dto.AccountDto;
import com.company.UsolDemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceIml implements AccountService{
    @Autowired
    private AccountRepository repo;


    @Override
    public Account saveAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public List<AccountDto> getAll() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        List<Account> accountList = repo.findAll();
        for(Account account : accountList){
            accountDtoList.add(new AccountDto(account));
        }
        return accountDtoList;
    }
}
