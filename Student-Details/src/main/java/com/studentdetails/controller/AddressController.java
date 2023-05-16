package com.studentdetails.controller;

import com.studentdetails.model.Address;
import com.studentdetails.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping(value = "all")
    public ResponseEntity<List<Address>> getAllAddress() {
        return addressService.getAllAddress();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable String id) {
        return addressService.deleteAddressById(id);
    }
}