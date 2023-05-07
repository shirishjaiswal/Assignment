package com.assignment.Ecommerce.controller;

import com.assignment.Ecommerce.model.User;
import com.assignment.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public Optional<User> getById(@PathVariable String id){
        return userService.getById(id);
    }
    @PostMapping(value = "/insert")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
