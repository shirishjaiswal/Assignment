package com.assignment.Ecommerce.controller;

import com.assignment.Ecommerce.model.Address;
import com.assignment.Ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping(value = "/insert")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
}
