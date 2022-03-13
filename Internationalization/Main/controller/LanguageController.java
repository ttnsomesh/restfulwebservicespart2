package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class LanguageController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello")
    public String getMessageFromProperties(@RequestHeader(name = "Accept-Language" , required = false) Locale locale){
        return messageSource.getMessage("good.morning.message" ,null ,  locale);
    }

    @GetMapping("/Internationalisation")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale, @RequestParam String username) {
        return messageSource.getMessage("good.morning.message", null, locale)+" "+username;
    }
}
