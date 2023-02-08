package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.AccountNotFoundException;
import com.company.UsolDemo.exception.BrandNotFoundException;
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
    public Account save(Account account) {
        account.setAccountRole(1);
        account.setAccountStatus(1);
        return repo.save(account);
    }

    @Override
    public List<Account> getAll() {
        return repo.findAll();
    }

    @Override
    public Account findById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new AccountNotFoundException(id));
    }

    @Override
    public Account update(Account newAccount, Long id) {
        return repo.findById(id)
                .map(account -> {
                    account.setAccountRole(newAccount.getAccountRole());
                    account.setAccountImage(newAccount.getAccountImage());
                    account.setAccountStatus(newAccount.getAccountStatus());
                    account.setEmail(newAccount.getEmail());
                    account.setAddress(newAccount.getAddress());
                    account.setFullName(newAccount.getFullName());
                    account.setPhone(newAccount.getPhone());
                    account.setUserName(newAccount.getUserName());
                    account.setPassword(newAccount.getPassword());
                    return repo.save(account);
                }).orElseThrow(()->new AccountNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if(!repo.existsById(id)){
            throw new AccountNotFoundException(id);
        }
        repo.deleteById(id);
        return "Account with id "+ id +" id has been deleted success!";
    }

}
