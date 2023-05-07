package com.assignment.Ecommerce.service;

import com.assignment.Ecommerce.model.Address;
import com.assignment.Ecommerce.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;
    public String addAddress(Address address) {
        Address saved = addressRepo.save(address);
        if(saved != null) {
            return "Address Saved";
        }
        return "Address is not saved";
    }
}
