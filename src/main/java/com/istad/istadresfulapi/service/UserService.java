package com.istad.istadresfulapi.service;

import com.istad.istadresfulapi.model.User;
import com.istad.istadresfulapi.model.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface UserService {
    List<User> allUsers();
    List<User> findUserByName();

    User findUserById(int id);

    int createNewUser(User  user);
    int updateUser(User  user, Integer id);
    int removeUser(int id);

    List<UserAccount>getAllUserAccounts();
}
