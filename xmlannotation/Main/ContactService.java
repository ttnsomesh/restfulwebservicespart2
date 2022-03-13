package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactService {
    public static List<Contact> contacts = new ArrayList<>();
    public static int countPrimary = 3;
    static {
        contacts.add(new Contact(123 , "somesh" , "8574123658"));
        contacts.add(new Contact(124 , "tushar" , "9574123658"));
        contacts.add(new Contact(125 , "mink" , "7574123658"));
    }

    public List<Contact> findAll() {
        return contacts;
    }

    public Contact saveContacts(Contact contact){
        if(contact.getId() == null){
            contact.setId(++countPrimary);
        }
        contacts.add(contact);
        return contact;
    }

    public Contact findOne(int id){
        for(Contact contact : contacts){
            if(contact.getId() == id){
                return contact;
            }
        }
        return null;
    }
}