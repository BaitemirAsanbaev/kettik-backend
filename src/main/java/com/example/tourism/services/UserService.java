package com.example.tourism.services;

import com.example.tourism.dto.UserRequest;
import com.example.tourism.models.User;

public interface UserService{
    User register(UserRequest request);
    User login(String email, String password);
    User profile(String token);
    User deleteProfile(String token);
    User editProfile(String token, UserRequest request);
}
