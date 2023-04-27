package com.istad.istadresfulapi.model.response;

import com.istad.istadresfulapi.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponse {

        private int id;
        private String accountName;
        private String accountNumber;
        private String profile;
        private String phoneNumber;
        private int transferLimit;
//        private int accountType;
        private AccountType accountType;

    }


