package com.java.banking.controller;

import com.java.banking.entity.Account;
import com.java.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
        //public String Account(){
        // return "accounts";
    }

    @PostMapping("/api/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/api/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/accounts/{id}")
    //public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
    // accountService.deleteAccount(id);
//        return new ResponseEntity<>(HttpStatus.FOUND);
//    public String deleteAccount(@RequestBody Account account) {
//
//        return accountService.deleteAccount(account);
//    }

    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "Account with ID " + id + " has been deleted successfully.";
    }

    @PutMapping("/update")
    public String updateAccount(@RequestBody Account account) {

        return accountService.updateAccount(account);
    }
}