package com.example.tourism.dto;

public record UserRequest (
    String firstname,
    String lastname,
    String email,
    String phone,
    String password
){}