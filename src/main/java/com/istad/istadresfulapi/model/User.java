package com.istad.istadresfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int UserID;
    private String username;
    private String gender;
    private String address;

}
