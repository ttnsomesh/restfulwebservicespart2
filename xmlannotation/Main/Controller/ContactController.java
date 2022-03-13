package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/users")
    public List<Contact> getAllContacts(){
        return contactService.findAll();
    }

    @GetMapping("users/{id}")
    public Contact getContact(@PathVariable int id){
        Contact one = contactService.findOne(id);
        return one;
    }

    @PostMapping("/users")
    public void addContact(@RequestBody Contact contact){
        Contact c = contactService.saveContacts(contact);
    }
}