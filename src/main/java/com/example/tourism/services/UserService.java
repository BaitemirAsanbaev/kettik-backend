package com.example.tourism.services;

import com.example.tourism.dto.UserRequest;

public interface UserService{
    String register(UserRequest request);
    String login(String email, String password);
}
