package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.dto.AccountDto;
import com.company.UsolDemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping("/add")
    public String add(@RequestBody Account account){
        service.saveAccount(account);
        return "New Account added!";
    }
    @GetMapping("/getAll")
    public List<AccountDto> getAll(){
        return service.getAll();
    }
}
