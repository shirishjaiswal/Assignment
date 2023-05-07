package com.assignment.Ecommerce.service;

import com.assignment.Ecommerce.model.User;
import com.assignment.Ecommerce.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    //GET - BY ID
    public Optional<User> getById(String id) {
        return userRepo.findById(Integer.parseInt(id));
    }

    //POST
    public String addUser(User user) {
        User saved = userRepo.save(user);
        if(saved != null) {
            return "User saved with id : " + user.getId();
        }
        return "User is not saved";
    }
}