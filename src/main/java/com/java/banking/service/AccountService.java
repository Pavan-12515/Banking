package com.java.banking.service;

import com.java.banking.entity.Account;
import com.java.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    // public void deleteAccount(Long id) {
    // accountRepository.deleteById(id);
//    public String deleteAccount(Account account) {
//        return "deleted";
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


    public String updateAccount(Account account) {
        Optional<Account> existingAccount = accountRepository.findById(account.getId());
        if (existingAccount.isPresent()) {
            Account accountToUpdate = existingAccount.get();
            accountToUpdate.setAccountHolderName(account.getAccountHolderName());
            accountToUpdate.setBalance(account.getBalance());
            accountRepository.save(accountToUpdate);
            return "Account updated successfully!";
        }
        return "Account not found!";
    }
//        return accountRepository.save(accountToUpdate);

    }


