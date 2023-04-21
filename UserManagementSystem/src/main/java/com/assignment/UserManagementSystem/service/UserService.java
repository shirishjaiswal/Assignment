package com.assignment.UserManagementSystem.service;

import com.assignment.UserManagementSystem.repository.UserDatabase;
import com.assignment.UserManagementSystem.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDatabase userDatabase;

    //Get all users
    public List<User> getUsers() {
        return userDatabase.getUsers();
    }

    //Find user by Id
    public User userFindById(String userId) {
        List<User> serviceUser = userDatabase.getUsers();
        if (userId != null) {
            for (User user : serviceUser) {
                if (user.getUserId().equals(userId)) {
                    return user;
                }
            }
        }
        return null;
    }

    //add user in Database
    public boolean addUserInDB(User user) {
        return userDatabase.addUser(user);
    }

    //delete user from db
    public boolean userDelete(String userId) {
        User toDelete = userFindById(userId);
        boolean isdeleted = false;
        if (toDelete != null) {
            isdeleted = userDatabase.userDelete(toDelete);
        }
        return isdeleted;
    }

    //get user by Id
    public User getUserById(String userId) {
        User toGet = userFindById(userId);
        if (toGet != null) {
            return toGet;
        }
        return null;
    }

    //Update user info
    public boolean userUpdate(User user) {
        User toUpdate = userFindById(user.getUserId());
        User toDel = toUpdate;
        if (toUpdate != null) {
            if (user.getUserName() != null && !toUpdate.getUserName().equals(user.getUserName())) {
                toUpdate.setUserName(user.getUserName());
            }
            if (user.getName() != null && !toUpdate.getName().equals(user.getName())) {
                toUpdate.setName(user.getName());
            }
            if (user.getAddress() != null && !toUpdate.getAddress().equals(user.getAddress())) {
                toUpdate.setAddress(user.getAddress());
            }
            if (user.getMobileNo() != null && !toUpdate.getMobileNo().equals(user.getMobileNo())) {
                toUpdate.setMobileNo(user.getMobileNo());
            }
        }
        boolean isDeleted = userDatabase.userDelete(toDel);
        boolean isAdded = false;
        if (isDeleted) {
            isAdded = addUserInDB(toUpdate);
        }
        return isAdded;
    }
}
