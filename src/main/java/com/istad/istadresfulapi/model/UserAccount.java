package com.istad.istadresfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserAccount {
    private int UserID;
    private String username;
    private String gender;
    private String address;
    private List<Account> accounts;


}
