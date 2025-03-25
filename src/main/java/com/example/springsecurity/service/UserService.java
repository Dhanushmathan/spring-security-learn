package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.repo.UserDetailsRepo;

@Service
public class UserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserDetailsRepo userDetailsRepo;

    public void addUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
    }

}
