package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ContactService {
    public static List<ContactPerson> contacts = new ArrayList<>();
    public static int countPrimary = 3;
    static {
        contacts.add(new ContactPerson(123 , "somesh" , "8574123658"));
        contacts.add(new ContactPerson(124 , "tushar" , "9574123658"));
        contacts.add(new ContactPerson(125 , "mink" , "7574123658"));
    }

    public List<ContactPerson> findAll() {
        return contacts;
    }

    public ContactPerson saveContacts(ContactPerson contact){
        if(contact.getId() == null){
            contact.setId(++countPrimary);
        }
        contacts.add(contact);
        return contact;
    }

    public ContactPerson findOne(int id){
        for(ContactPerson contact : contacts){
            if(contact.getId() == id){
                return contact;
            }
        }
        return null;
    }
    public ContactPerson deleteById(int id){
        Iterator<ContactPerson> it = contacts.iterator();
        while(it.hasNext()){
            ContactPerson e = it.next();
            if(e.getId() == id){
                it.remove();
                return e;
            }
        }
        return null;
    }
}