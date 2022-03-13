package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoApplication {
    private static List<User> users = new ArrayList<>();
    private static int countPrimary = 3;
    static {
        users.add(new User(1 , "somesh" , new Date()));
        users.add(new User(2 , "tushar" , new Date()));
        users.add(new User(3 , "dinesh" , new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUsers(User user){
        if(user.getId() == null){
            user.setId(++countPrimary);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User user = it.next();
            if(user.getId() == id){
                it.remove();
                return user;
            }
        }
        return null;
    }


}
