package com.example.tourism.services;

import com.example.tourism.models.Order;
import org.apache.http.auth.AuthenticationException;
import org.springframework.expression.AccessException;

import java.util.List;

public interface OrderService {
    Order order(String note, String token) throws AuthenticationException;
    List<Order> allOrders(String token) throws AuthenticationException, AccessException;
}
