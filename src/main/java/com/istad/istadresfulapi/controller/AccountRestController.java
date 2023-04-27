package com.istad.istadresfulapi.controller;


import com.istad.istadresfulapi.mapper.AutoAccountMapper;
import com.istad.istadresfulapi.model.Account;
import com.istad.istadresfulapi.model.response.AccountResponse;
import com.istad.istadresfulapi.service.AccountService;
import com.istad.istadresfulapi.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountRestController {
    // inject accountService
    private  final AccountService accountService;
    private final AutoAccountMapper autoAccountMapper;

    AccountRestController(AccountService accountService, AutoAccountMapper autoAccountMapper){
        this.accountService = accountService;
        this.autoAccountMapper = autoAccountMapper;
    }

    @GetMapping("/allAccounts")
    public Response<List<AccountResponse>> getAllAccounts(){
        try{
            List<Account> allAccount = accountService.getAllAccounts();
            List<AccountResponse> accountResponses = autoAccountMapper.mapToAccountResponse(allAccount);
            //model mapper, mapstruct
//            HashMap<String , Object> response = new HashMap<>();
//            response.put("payload", accountResponses);
//            response.put("message","Successfully retrieve all accounts info!");
//            response.put("status", HttpStatus.OK);
            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("successfully retrieve all account information ");

        }catch (Exception exception){
            System.out.println("Something wrong : "+exception.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception occurs! Failed to retrieve the accounts");
        }
    }


}
