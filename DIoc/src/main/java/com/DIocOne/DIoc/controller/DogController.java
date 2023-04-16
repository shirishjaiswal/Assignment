package com.DIocOne.DIoc.controller;

import com.DIocOne.DIoc.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @Autowired
    Dog d1;
    @GetMapping (value = "/bunny")
    public Dog getDog () {
        return d1;
    }
}
