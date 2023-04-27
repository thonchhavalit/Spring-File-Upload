package com.istad.istadresfulapi.service;

import com.istad.istadresfulapi.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account, int id);
    Account findAccountByID(int id);

}
