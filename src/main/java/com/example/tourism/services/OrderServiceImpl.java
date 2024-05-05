package com.example.tourism.services;

import com.example.tourism.models.Order;
import com.example.tourism.models.User;
import com.example.tourism.repositories.OrderRepo;
import com.example.tourism.repositories.UserRepo;
import com.example.tourism.security.AdminMiddleware;
import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    UserRepo userRepo;
    @Override
    public Order order(String note, String token) throws AuthenticationException {
        User user = userRepo.findByToken(token);
        if (user==null) throw new AuthenticationException("invalid token");
        Order order = new Order();
        order.setUser(user);
        order.setNote(note);
        orderRepo.save(order);
        return order;
    }

    @Override
    public List<Order> allOrders(String token) throws AuthenticationException, AccessException {
        User user = userRepo.findByToken(token);
        if (user==null) throw new AuthenticationException("invalid token");
        if (!AdminMiddleware.isAdmin(user.getEmail())) {
            throw new AccessException("User is not admin");
        }
        return orderRepo.findAll();
    }
}
