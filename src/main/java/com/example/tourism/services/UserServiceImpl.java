package com.example.tourism.services;

import com.example.tourism.dto.UserRequest;
import com.example.tourism.models.User;
import com.example.tourism.repositories.UserRepo;
import com.example.tourism.security.SHA256;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @SneakyThrows
    @Override
    public String register(UserRequest request) {

        if (userRepo.findByEmail(request.email()) != null){
            return "Пользователь уже существует";
        }

        final String token = SHA256.hash(request.email());

        User user = new User();
        user.setFirstname(request.firstname());
        user.setLastname(request.lastname());
        user.setPhone(request.phone());
        user.setEmail(request.email());
        user.setPassword(SHA256.hash(request.password()));
        user.setToken(token);
        userRepo.save(user);
        return token;
    }

    @SneakyThrows
    @Override
    public String login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if ( user == null){
            return "Пользователь не найден";
        }
        if(!user.getPassword().equals(SHA256.hash(password))){
            return "Неверный пароль";
        }
        return user.getToken();
    }
}
