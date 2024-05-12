package com.example.tourism.controllers;

import com.example.tourism.services.UserService;
import com.example.tourism.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest user) {
        try {
            return ResponseEntity.ok(userService.register(user));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest user) {
        try {
            return ResponseEntity.ok(userService.login(user.email(), user.password()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<?> profile(@RequestHeader("Authorization") String header){

        String token = header.split(" ")[1];
        try{
            return ResponseEntity.ok(userService.profile(token));
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    @DeleteMapping("/profile/delete")
    public ResponseEntity<?> deleteProfile(@RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return ResponseEntity.ok(userService.deleteProfile(token));
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
    @PatchMapping("/profile/edit")
    public ResponseEntity<?> editProfile(@RequestHeader("Authorization") String header, @RequestBody UserRequest request){
        String token = header.split(" ")[1];
        try{
            return ResponseEntity.ok(userService.editProfile(token, request));
        }
        catch (RuntimeException e){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

