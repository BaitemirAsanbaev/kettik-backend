package com.example.tourism.controllers;

import com.example.tourism.dto.OrderRequest;
import com.example.tourism.models.Order;
import com.example.tourism.services.OrderService;
import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request, @RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return ResponseEntity.ok(orderService.order(request.note(), token));
        }
        catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestHeader("Authorization")String header){
        String token = header.split(" ")[1];
        try{
            return ResponseEntity.ok(orderService.allOrders(token));
        }
        catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        catch (AccessException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

}
