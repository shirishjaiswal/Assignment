package com.assignment.Restaurant.controller;

import com.assignment.Restaurant.service.ServiceRestaurant;
import com.assignment.Restaurant.service.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    ServiceRestaurant serviceRestaurant;

    @RequestMapping (value = "/id/{name}", method = RequestMethod.GET)
    public String getId(@PathVariable String name) {
        return serviceRestaurant.getId(name);
    }

    @RequestMapping (value = "/all", method = RequestMethod.GET)
    public List<Restaurant> getRestaurants (){
        return serviceRestaurant.getRestaurantRepo();
    }

    @RequestMapping (value = "/add", method = RequestMethod.POST)
    public String addRestaurant (@RequestBody Restaurant restaurant) {
        boolean isAdded = serviceRestaurant.addRestaurant(restaurant);
        if(isAdded) return "Restaurant added Successfully";
        return "UnSuccessful";
    }

    @RequestMapping (value = "/update/{name}/{speciality}", method = RequestMethod.PUT)
    public String updateSpeciality (@PathVariable String name, @PathVariable String speciality) {
        boolean isUpdated = serviceRestaurant.updateSpeciality(name, speciality);
        if (isUpdated) return "Successfully Updated";
        return "Unsuccessful";
    }

    @RequestMapping (value = "/delete/{name}", method = RequestMethod.DELETE)
    public String deleteRestaurant (@PathVariable String name) {
        boolean isDeleted = serviceRestaurant.deleteRestaurant(name);
        if(isDeleted) return "Deletion Successful";
        return "Deletion Unsuccessful";
    }
}
