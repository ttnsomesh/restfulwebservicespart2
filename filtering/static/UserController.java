package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public UserStatic getFilteringPasswordstatic(@PathVariable int id){
        UserStatic user = userService.findOne(id);
        return new UserStatic(user.getId() , user.getName() , user.getEmail() , user.getPassword());
    }

//    @GetMapping("users/dynamic/{id}")
//    public UserDynamic getfilteringPasswordDynamic(@PathVariable int id){
//        UserDynamic userDynamic = userService.findOne(id);
//    }

    @GetMapping("/users")
    public List<UserStatic> getAllContacts(){
        return userService.findAll();
    }

//    @GetMapping("users/{id}")
//    public User getContact(@PathVariable int id){
//        User one = userService.findOne(id);
//        return one;
//    }

    @PostMapping("/users")
    public void addContact(@RequestBody UserStatic user){
        UserStatic c = userService.saveContacts(user);
    }
}
