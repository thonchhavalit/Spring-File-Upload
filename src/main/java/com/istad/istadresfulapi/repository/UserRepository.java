package com.istad.istadresfulapi.repository;

import com.istad.istadresfulapi.model.Account;
import com.istad.istadresfulapi.model.User;
import com.istad.istadresfulapi.model.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {


    @Result(column = "id", property = "UserID")
    @Select("select * from users_tb")
    List<User> allUsers();
    List<User> findUserByUserName(String name);
    @Insert("insert into users_tb (username, gender, address) values (#{user.username}, #{user.gender}, #{user.address})")
    int createNewUser(@Param("user") User user);


    @Update("UPDATE users_tb SET username=#{user.username},gender=#{user.gender},address=#{user.address} WHERE id=#{id}")
    int updateUser(@Param("user") User user,@Param("id") Integer id);

    @Select("select * from users_tb where id = #{id}")
    User findUserById(int id);


    @Delete("DELETE FROM users_tb WHERE id=#{id}")
    int removeUser(@Param("id") Integer id);


    @Results({
            @Result(column = "id", property = "userID"),
            @Result(column = "id", property = "accounts", many = @Many(select = "findAccountsByUserId"))
    })
//    @Result(column = "user_id", property = "UserID")
    @Select("SELECT * FROM users_tb")
    List<UserAccount> getAllUserAccounts();
    @Results({
            @Result(property = "accountName",column = "account_name"),
            @Result(property = "accountNumber", column = "account_no"),
            @Result(property ="transferLimit", column = "transfer_limit"),
            @Result(property = "password", column = "passcode"),
            @Result(property = "accountType", column = "account_type",
                    one = @One(select = "com.istad.istadresfulapi.repository.AccountRepository.getAccountTypeByID"))})

    @Select("SELECT * FROM  user_account_tb\n" +
            "    inner join account_tb\n" +
            "        a on a.id = user_account_tb.accout_id\n" +
            " WHERE user_id = #{id};")
    List<Account> findAccountsByUserId(int id);

}
