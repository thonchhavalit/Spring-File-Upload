package com.istad.istadresfulapi.service.serviceImp;

import com.istad.istadresfulapi.model.User;
import com.istad.istadresfulapi.model.UserAccount;
import com.istad.istadresfulapi.repository.UserRepository;
import com.istad.istadresfulapi.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImp implements UserService {


    UserRepository userRepository;
    UserServiceImp (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    @Override
    public List<User> findUserByName() {

        return null;
    }

    @Override
    public User findUserById(int id) {
//        return userRepository.;
        return userRepository.findUserById(id);
    }

    @Override
    public int createNewUser(@Param("user") User user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(User user, Integer id) {
        return userRepository.updateUser(user,id);
    }



    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }

}
