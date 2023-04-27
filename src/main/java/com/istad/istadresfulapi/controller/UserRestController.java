package com.istad.istadresfulapi.controller;


import com.istad.istadresfulapi.model.User;
import com.istad.istadresfulapi.model.UserAccount;
import com.istad.istadresfulapi.service.UserService;
import com.istad.istadresfulapi.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private final  UserService userService;
    @Autowired
    UserRestController(UserService userService){
        this.userService=userService;

    }
        @GetMapping("/allUsers")

        List<User> getAllUsers(){
            return userService.allUsers();

    }

        @GetMapping("/user/{id}")
        public User findUserById(@PathVariable int id){
            return userService.findUserById(id);
        }


        @PostMapping("/new-user")
    public String createUser(@RequestBody User user){
            System.out.println("User is : "+user);
        try {
            int affectRow = userService.createNewUser(user);
            System.out.println("Affect Row : " + affectRow);
            if (affectRow>0)
                return "Create New User SuccessFully ";
            else
                return "Can't Crate New User";
        }catch (Exception e){
            return e.getMessage();
        }


        }

        @GetMapping("/user-accounts")
        public Response<List<UserAccount>> getAllUserAccounts(){
        try{
            List<UserAccount> data = userService.getAllUserAccounts();
            return Response.<List<UserAccount>>ok().setPayload(data).setMessage("successfully retrieved all user accounts!!");

        }catch (Exception e){
            return Response.<List<UserAccount>>exception().setMessage("Fail to retrieved all user accounts!!").setSuccess(false);
        }
        }
    @DeleteMapping("/remove/{id}")
    Response<User> removeUser(@PathVariable("id")Integer id){
        try {
            int result= userService.removeUser(id);
            if(result>0) {
                return Response.<User>deleteSuccess().setMessage("One Row Is Delete.");
            }else {
                return Response.<User>ok().setMessage("Not found user by id :"+id);
            }
        }catch (Exception e){
            System.out.println("this is error :"+e);
            return Response.<User>exception().setMessage("Remove Value Fail.").setSuccess(false);
        }

    }
    @GetMapping("/update/{id}")
    Response<User> updateUser(@RequestBody User user,@PathVariable("id") Integer id){
        try {
            int result= userService.updateUser(user,id);
            if(result>0) {
                return Response.<User>updateSuccess().setPayload(user).setMessage("You are update successfully.");
            }else {
                return Response.<User>ok().setMessage("Not found user by id :"+id);
            }
        }catch (Exception e){
            System.out.println("this is error :"+e);
            return Response.<User>exception().setMessage("Update Value Fail.").setSuccess(false);
        }
    }
    }


