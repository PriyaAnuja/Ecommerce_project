package com.ecommerce1.productservice1.controllers;

import com.ecommerce1.productservice1.dtos.CreateUserDto;
import com.ecommerce1.productservice1.models.User;
import com.ecommerce1.productservice1.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }
}
