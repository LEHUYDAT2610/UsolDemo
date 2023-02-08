package com.company.UsolDemo.controller;

import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.dto.AccountDto;
import com.company.UsolDemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAll() {
//        List<Account> accounts = service.getAll();
//        List<AccountDto> accountDtos = new ArrayList<>();
//        for(Account account : accounts){
//            accountDtos.add(new AccountDto(account));
//        }
//        return ResponseEntity.ok(accountDtos);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//        AccountDto accountDto = new AccountDto(service.findById(id));
//        return ResponseEntity.ok(accountDto);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<?> insert(@RequestBody Account newAccount){
//        AccountDto accountDto = new AccountDto(service.save(newAccount));
//        return ResponseEntity.ok(accountDto);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody Account account,@PathVariable Long id){
//        AccountDto accountDto = new AccountDto(service.update(account,id));
//        return ResponseEntity.ok(accountDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id){
//        return ResponseEntity.ok(service.delete(id));
//    }
}
