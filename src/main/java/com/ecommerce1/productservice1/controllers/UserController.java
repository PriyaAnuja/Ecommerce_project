package com.ecommerce1.productservice1.controllers;

import com.ecommerce1.productservice1.dtos.CreateUserDto;
import com.ecommerce1.productservice1.dtos.GetInstructorDto;
import com.ecommerce1.productservice1.models.Instructor;
import com.ecommerce1.productservice1.models.User;
import com.ecommerce1.productservice1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody CreateUserDto createUserDto){
        return userService.createInstructor(createUserDto.getName(), createUserDto.getEmail());
    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/instructor/{name}")
    public List<GetInstructorDto> getInstructorByName(@PathVariable(name = "name") String name){
        return userService.getInstructorByName(name);
    }
}
