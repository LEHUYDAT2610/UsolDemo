package com.company.UsolDemo.service;

import com.company.UsolDemo.exception.AccountNotFoundException;
import com.company.UsolDemo.exception.BrandNotFoundException;
import com.company.UsolDemo.models.Account;
import com.company.UsolDemo.models.Brand;
import com.company.UsolDemo.models.dto.AccountDto;
import com.company.UsolDemo.models.dto.BrandDto;
import com.company.UsolDemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountServiceIml implements AccountService{
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    private AccountRepository repo;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public Account save(Account account) {
        account.setAccountRole(1);
        account.setAccountStatus(1);
        return repo.save(account);
    }

    @Override
    public void Registration(Account account) {
        String image="";
        account.setAccountImage(image);
        BCryptPasswordEncoder bcript=new BCryptPasswordEncoder();
        String passEncode= bcript.encode(account.getPassword());
        account.setPassword(passEncode);
        account.setAccountRole(1);
        account.setAccountStatus(1);
        repo.save(account);
    }
    private static void getImageFromDto(AccountDto accountDto, Account account) {
        MultipartFile image=accountDto.getAccountImage();
        Path path = Paths.get("uploads/");
        if(image.isEmpty()){
            account.setAccountImage("defaul.jpg");
        }
        try {
            InputStream inputStream = image.getInputStream();
            Files.copy(inputStream,path.resolve(image.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            account.setAccountImage(image.getOriginalFilename().toLowerCase());
        }catch (Exception ex){

        }
    }

    @Override
    public Account UpdateAccount(long id,AccountDto accountDto) {
        return repo.findById(id)
                .map(account -> {
                    account.setUserName(accountDto.getUserName());
                    account.setFullName(accountDto.getFullName());
                    account.setAddress(accountDto.getAddress());
                    account.setPhone(accountDto.getPhone());
                    account.setEmail(accountDto.getEmail());
                    MultipartFile image=accountDto.getAccountImage();
                    Path path = Paths.get("uploads/account/");
                    if(image.isEmpty()){
                        account.setAccountImage("defaul.jpg");
                    }
                    try {
                        InputStream inputStream = image.getInputStream();
                        Files.copy(inputStream,path.resolve(image.getOriginalFilename()),
                                StandardCopyOption.REPLACE_EXISTING);
                        account.setAccountImage(image.getOriginalFilename().toLowerCase());
                    }catch (Exception ex){
                    }
                    return repo.save(account);
                }).orElseThrow(()->new AccountNotFoundException(id));
    }


    @Override
    public List<Account> getAll() {
        return repo.findAll();
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

    @Override
    public Account ChangePassword(long id, Account accountDto) {
        return repo.findById(id)
                .map(account -> {
                    BCryptPasswordEncoder bcript=new BCryptPasswordEncoder();
                    String passEncode= bcript.encode(account.getPassword());
                    account.setPassword(passEncode);
                    return repo.save(account);
                }).orElseThrow(()->new AccountNotFoundException(id));
    }

    @Override
    public Account UpdateAccountAd(long id, Account account1,MultipartFile image) {
        return repo.findById(id)
                .map(account -> {
                    account.setUserName(account1.getUserName());
                    account.setFullName(account1.getFullName());
                    account.setPassword(account1.getPassword());
                    account.setAddress(account1.getAddress());
                    account.setPhone(account1.getPhone());
                    account.setEmail(account1.getEmail());
                    Path path = Paths.get("uploads/account/");
                    if(image.isEmpty()){
                        account.setAccountImage("defaul.jpg");
                    }
                    try {
                        InputStream inputStream = image.getInputStream();
                        Files.copy(inputStream,path.resolve(image.getOriginalFilename()),
                                StandardCopyOption.REPLACE_EXISTING);
                        account.setAccountImage(image.getOriginalFilename().toLowerCase());
                    }catch (Exception ex){
                    }
                    account.setAccountStatus(account1.getAccountStatus());
                    account.setAccountRole(account1.getAccountRole());
                    return repo.save(account);
                }).orElseThrow(()->new AccountNotFoundException(id));
    }
    public static long RandomPass(long min, long max){
        double randompass = Math.random() * (max - min + 1) + min;
        return (long) randompass;
    }
    @Override
    public String SendPassword(String email) {
        Account account=repo.findByEmail(email);
        long pass=RandomPass(100000,999999);
        if(account==null){
            return "Email không có trong hệ thống";
        }
        else {
            try {
                // Creating a simple mail message
                SimpleMailMessage mailMessage= new SimpleMailMessage();
                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(email);
                mailMessage.setText("Mật khẩu mới của bạn là: "+pass);
                mailMessage.setSubject("Lấy lại mật khẩu");
                // Sending the mail
                account.setPassword(Long.toString(pass));
                repo.save(account);
                javaMailSender.send(mailMessage);
                return "Mail Sent Successfully...";
            }
            catch (Exception e) {
                return e.getMessage();
            }
        }


    }

}
