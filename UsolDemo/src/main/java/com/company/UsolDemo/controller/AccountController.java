package com.company.UsolDemo.controller;

import com.company.UsolDemo.ExcelExport.AccountExcelExporter;
import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.Product;
import com.company.UsolDemo.models.dto.AccountDto;
import com.company.UsolDemo.models.dto.BrandDto;
import com.company.UsolDemo.service.AccountService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@CrossOrigin
@RestController
@RequestMapping("/account")

public class AccountController {
    @Autowired
    private AccountService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Account> accounts = service.getAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Account account = service.findById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping(value = "/add",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestParam("userName") String userName,
                                    @RequestParam("fullName") String fullName,
                                    @RequestParam("password") String password,
                                    @RequestParam("address") String address,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("email") String email,
                                    @RequestParam("accountImage") MultipartFile accountImage,
                                    @RequestParam("accountStatus") int accountStatus,
                                    @RequestParam("accountRole") int accountRole) {
        AccountDto accountDto = new AccountDto(password, userName, fullName, address, phone, email, accountImage, accountStatus, accountRole);
        return ResponseEntity.ok(service.save(accountDto));
    }

    @PutMapping("/withImage/{id}")
    public ResponseEntity<?> updateWithImage(@RequestParam("userName") String userName,
                                             @RequestParam("fullName") String fullName,
                                             @RequestParam("password") String password,
                                             @RequestParam("address") String address,
                                             @RequestParam("phone") String phone,
                                             @RequestParam("email") String email,
                                             @RequestParam("accountImage") MultipartFile accountImage,
                                             @RequestParam("accountStatus") int accountStatus,
                                             @RequestParam("accountRole") int accountRole,
                                             @PathVariable Long id) {
        AccountDto accountDto = new AccountDto(password, userName, fullName, address, phone, email, accountImage, accountStatus, accountRole);
        return ResponseEntity.ok(service.update(accountDto,id));
    }

    @PutMapping("/noImage/{id}")
    public ResponseEntity<?> updateNoImage(@RequestParam("userName") String userName,
                                             @RequestParam("fullName") String fullName,
                                             @RequestParam("password") String password,
                                             @RequestParam("address") String address,
                                             @RequestParam("phone") String phone,
                                             @RequestParam("email") String email,
                                             @RequestParam("accountStatus") int accountStatus,
                                             @RequestParam("accountRole") int accountRole,
                                             @PathVariable Long id) {
        AccountDto accountDto = new AccountDto(password, userName, fullName, address, phone, email, accountRole, accountStatus);
        return ResponseEntity.ok(service.update(accountDto,id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Account account) {
        service.Registration(account);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestParam("userName") String userName,
                                    @RequestParam("fullName") String fullName,
                                    @RequestParam("address") String address,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("email") String email,
                                    @RequestParam("image") MultipartFile image) {
        AccountDto accountDto = new AccountDto(userName, fullName, address, phone, email, image);
        return ResponseEntity.ok(service.UpdateAccount(id, accountDto));
    }

    @PutMapping("/changepass/{id}")
    public ResponseEntity<?> ChangPass(@PathVariable Long id, @RequestParam String pass) {
        Account account = new Account(pass);
        return ResponseEntity.ok(service.ChangePassword(id, account));
    }

    //Update account Admin
    @PutMapping("/changeaccountadmin/{id}")
    public ResponseEntity<?> updateAccountAdmin(@PathVariable Long id,
                                                @RequestParam("UserName") String UserName,
                                                @RequestParam("fullName") String fullName,
                                                @RequestParam("password") String password,
                                                @RequestParam("address") String address,
                                                @RequestParam("phone") String phone,
                                                @RequestParam("email") String email,
                                                @RequestParam("Status") int Status,
                                                @RequestParam("Role") int Role,
                                                @RequestParam("image") MultipartFile image) {
        Account account = new Account(UserName, fullName, password, address, phone, email, Status, Role);
        return ResponseEntity.ok(service.UpdateAccountAd(id, account, image));
    }

    @PostMapping("/sendpass")
    public ResponseEntity<?> SendPassword(@RequestParam("email") String email) {
        String status = service.SendPassword(email);
        return ResponseEntity.ok(status);
    }

    //export account data excel chi can goi toi link localhost:8080/account/exportacccount/excel và gan link len thanh tim kiem goolge
// thi tu dong tai file excel ve
    @GetMapping("/exportacccount/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Account_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<Account> listUsers = service.getAll();
        AccountExcelExporter excelExporter = new AccountExcelExporter(listUsers);
        excelExporter.export(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
