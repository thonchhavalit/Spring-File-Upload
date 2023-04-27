package com.istad.istadresfulapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account{
    private int id;
    private String accountName;
    private String accountNumber;
    private int pin;
    private String password;
    private String phoneNumber;
    private int transferLimit;
//    private int accountType;
    private String profile;
    private AccountType accountType;
}
