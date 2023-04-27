package com.istad.istadresfulapi.service.serviceImp;

import com.istad.istadresfulapi.model.Account;
import com.istad.istadresfulapi.repository.AccountRepository;
import com.istad.istadresfulapi.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImp implements AccountService {

    private  final AccountRepository accountRepository;
    AccountServiceImp(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account, int id) {
        return 0;
    }

    @Override
    public Account findAccountByID(int id) {
        return accountRepository.findAccountByID(id);
    }
}
