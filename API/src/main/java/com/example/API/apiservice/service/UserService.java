package com.example.API.apiservice.service;

import com.example.API.apiservice.dto.RegisterRequest;
import com.example.API.apiservice.entity.User;
import com.example.API.apiservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // TODO: hash the password!
        return userRepository.save(user);
    }

}
