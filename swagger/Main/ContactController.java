package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AddressBookResources {

    @Autowired
    private ContactService contactService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/users")
    public List<ContactPerson> getAllContacts(){
        return contactService.findAll();
    }

    @GetMapping("users/{id}")
    public ContactPerson getContact(@PathVariable int id){
        ContactPerson one = contactService.findOne(id);
        return one;
    }


    @PostMapping("/users")
    public void addContact(@RequestBody ContactPerson contact){
        ContactPerson c = contactService.saveContacts(contact);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteUsers(@PathVariable int id){
        ContactPerson e = contactService.deleteById(id);
        if(e == null){
            throw new ResourcesNotFound ("id :"+id);
        }
    }
}