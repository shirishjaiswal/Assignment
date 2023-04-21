package com.assignment.UserManagementSystem.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String userId;
    private String name;
    private String userName;
//    private String address;

    @Autowired
    private Address address;
    private String mobileNo;

    public User(String userId, String name, String userName, Address address, String mobileNo) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    public User () {
    }
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    //===============

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
