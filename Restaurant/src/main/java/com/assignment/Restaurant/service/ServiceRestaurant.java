package com.assignment.Restaurant.service;

import com.assignment.Restaurant.repository.RepoRestaurant;
import com.assignment.Restaurant.service.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRestaurant {
    @Autowired
    RepoRestaurant restaurantRepo;

    public String getId (String name) {
        List<Restaurant> restaurantList = restaurantRepo.getRestaurantList();
        Restaurant restaurant = null;
        for (Restaurant temp : restaurantList) {
            if(temp.getName().equals(name)){
                restaurant = temp;
            }
        }
        return restaurant.getId();
    }

    public List<Restaurant> getRestaurantRepo() {
        return restaurantRepo.getRestaurantList();
    }

    public boolean addRestaurant (Restaurant restaurant) {
        return restaurantRepo.addRestaurant(restaurant);
    }

    public boolean updateSpeciality (String name, String speciality) {
        List<Restaurant> restaurantList = restaurantRepo.getRestaurantList();
        Restaurant restaurant = null;
        for (int i = 0; i < restaurantList.size(); i++) {
            if(restaurantList.get(i).getName().equals(name)){
                restaurant = restaurantList.get(i);
            }
        }
        Restaurant toDelete = restaurant;
        restaurant.setSpeciality(speciality);
        boolean isDeleted = restaurantRepo.deleteRestaurant(toDelete);
        boolean isAdded = false;
        if(isDeleted) {
            isAdded = restaurantRepo.addRestaurant(restaurant);
        }
        return isAdded;
    }

    public boolean deleteRestaurant (String name) {
        List<Restaurant> restaurantList = restaurantRepo.getRestaurantList();
        Restaurant restaurant = null;
        for (int i = 0; i < restaurantList.size(); i++) {
            if(restaurantList.get(i).getName().equals(name)){
                restaurant = restaurantList.get(i);
            }
        }
        return restaurantRepo.deleteRestaurant(restaurant);
    }
}
