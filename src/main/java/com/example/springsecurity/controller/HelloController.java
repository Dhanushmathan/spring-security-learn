package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("/")
    public String Hello(HttpServletRequest request) {
        return "Hello World!" + request.getSession().getId();
    }

    @GetMapping("/about")
    public String HelloWorld() {
        return "Hey Dhanush What are you doing!!!";
    }

}
