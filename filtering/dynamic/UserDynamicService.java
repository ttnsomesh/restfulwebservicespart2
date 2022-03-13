package com.example.demo;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDynamicService{
    public static List<UserDynamic> users = new ArrayList<>();
    public static int countPrimary = 3;
    static {
        users.add(new UserDynamic(1 , "somesh" , "somesh123@gmail.com" , "somesh"));
        users.add(new UserDynamic(2 , "tushar" , "tushar123@gmail.com" , "tushar"));
        users.add(new UserDynamic(3 , "dinesh" , "dinesh123@gmail.com" , "dinesh"));

    }

    public List<UserDynamic> findAll() {
        return users;
    }

    public UserDynamic saveContacts(UserDynamic user){
        if(user.getId() == null){
            user.setId(++countPrimary);
        }
        users.add(user);
        return user;
    }

    public UserDynamic findOne(int id){
        for(UserDynamic user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
