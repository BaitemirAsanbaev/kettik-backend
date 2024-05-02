package com.example.tourism.controllers;

import com.example.tourism.services.UserService;
import com.example.tourism.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRequest user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest user) {
        return userService.login(user.email(), user.password());
    }
}

