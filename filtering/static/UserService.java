package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService{
    public static List<UserStatic> users = new ArrayList<>();
    public static int countPrimary = 3;
    static {
       users.add(new UserStatic(1 , "somesh" , "somesh123@gmail.com" , "somesh"));
        users.add(new UserStatic(2 , "tushar" , "tushar123@gmail.com" , "tushar"));
        users.add(new UserStatic(3 , "dinesh" , "dinesh123@gmail.com" , "dinesh"));

    }

    public List<UserStatic> findAll() {
        return users;
    }

    public UserStatic saveContacts(UserStatic user){
        if(user.getId() == null){
            user.setId(++countPrimary);
        }
        users.add(user);
        return user;
    }

    public UserStatic findOne(int id){
        for(UserStatic user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}