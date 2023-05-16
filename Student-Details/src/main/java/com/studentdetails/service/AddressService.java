package com.studentdetails.service;

import com.studentdetails.model.Address;
import com.studentdetails.model.Book;
import com.studentdetails.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> all = addressRepo.findAll();
        if(all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addAddress(Address address) {
        Address save = addressRepo.save(address);
        if(save != null) {
            return  new ResponseEntity<>("Address Saved", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteAddressById(String id) {
        if(addressRepo.existsById(Integer.parseInt(id))) {
            addressRepo.deleteById(Integer.parseInt(id));
            if(addressRepo.existsById(Integer.parseInt(id))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Address Deleted", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Address Not Found", HttpStatus.NOT_FOUND);
    }
}
