package com.assignment.UserManagementSystem.repository;

//import com.assignment.UserManagementSystem.service.model.Address;
import com.assignment.UserManagementSystem.service.model.Address;
import com.assignment.UserManagementSystem.service.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDatabase {
    private List<User> userDB;
    public UserDatabase () {
        userDB = new ArrayList<>();
        Address ad = new Address("Mumbai", "Maharashtra", "India");
        User us1 = new User("Dummy1", "Vishal", "v2shal", ad, "11111");
        User us2 = new User("Dummy2", "Manoj", "m2noj", ad, "22222");
        User us3 = new User("Dummy3", "Kishor", "k2ashor", ad, "33333");

        userDB.add(us1);
        userDB.add(us2);
        userDB.add(us3);
    }

    public List<User> getUsers () {
        return userDB;
    }

    public boolean addUser (User user) {
        return userDB.add(user);
    }

    public boolean userDelete(User user) {
        return userDB.remove(user);
    }
}
