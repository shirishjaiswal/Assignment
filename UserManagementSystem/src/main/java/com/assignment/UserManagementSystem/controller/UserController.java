package com.assignment.UserManagementSystem.controller;

import com.assignment.UserManagementSystem.service.UserService;
import com.assignment.UserManagementSystem.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Get all users
    //can use browser
    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.getUsers();
    }

    //Get users by id
    //can use browser
    @GetMapping(value = "/userId/{userId}")
    public User userById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    //Add user
    //use PostMan
    @PostMapping(value = "/user")
    public String userAdd(@RequestBody User user) {
        boolean isAdded = userService.addUserInDB(user);
        if(isAdded) return "Successfully added";
        return "Unsuccessful";
    }

    //Delete user
    //can use browser
    @DeleteMapping (value = "/userId/{userId}")
    public String userDelete(@PathVariable String userId) {
        boolean isDeleted = userService.userDelete(userId);
        if(isDeleted) return "Deleted";
        return "Not Deleted";
    }

    //user info update
    //using postman
    @PutMapping (value = "/userId")
    public String userUpdate (@RequestBody User user) {
        boolean isUpdated = userService.userUpdate(user);
        if(isUpdated) return "Updated";
        return  "Not Updated";
    }
}
