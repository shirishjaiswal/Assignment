package com.studentdetails.controller;

import com.studentdetails.model.Laptop;
import com.studentdetails.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/laptop")
public class LaptopController {
    @Autowired
    LaptopService laptopService;


    @GetMapping(value = "all")
    public ResponseEntity<List<Laptop>> getAllLaptop() {
        return laptopService.getAllLaptop();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop) {
        return laptopService.addLaptop(laptop);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteLaptopById(@PathVariable String id) {
        return laptopService.deleteLaptopById(id);
    }
}
