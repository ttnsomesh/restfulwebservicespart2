package com.example.demo;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDynamicController {
    @Autowired
    private UserDynamicService userService;


    @GetMapping("/users/dynamic/{id}")
    public MappingJacksonValue getfilteringPasswordDynamic(@PathVariable int id){
        UserDynamic userDynamic = userService.findOne(id);
        UserDynamic us = new UserDynamic(userDynamic.getId() , userDynamic.getName() , userDynamic.getEmail() , userDynamic.getPassword());
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","email");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter" , simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(us);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;

    }

    @GetMapping("/userdynamic")
    public List<UserDynamic> getAllContacts(){
        return userService.findAll();
    }

//    @GetMapping("users/{id}")
//    public User getContact(@PathVariable int id){
//        User one = userService.findOne(id);
//        return one;
//    }

    @PostMapping("/userdynamic")
    public void addContact(@RequestBody UserDynamic user){
        UserDynamic c = userService.saveContacts(user);
    }
}
