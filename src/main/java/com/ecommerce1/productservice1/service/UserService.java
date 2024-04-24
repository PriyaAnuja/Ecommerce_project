package com.ecommerce1.productservice1.service;

import com.ecommerce1.productservice1.models.User;
import com.ecommerce1.productservice1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).get();
    }
}
