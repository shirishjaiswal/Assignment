package com.assignment.Restaurant.repository;

import com.assignment.Restaurant.service.model.Address;
import com.assignment.Restaurant.service.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoRestaurant {
    private List<Restaurant> restaurantList;

    public RepoRestaurant() {
        restaurantList = new ArrayList<>();
        Address ad = new Address("Dummy", "parli", "Maharashtra");
        Restaurant res1 = new Restaurant("Dummy", "TAJ", ad, "5789632", "INDIAN", 125);
        restaurantList.add(res1);
    }

    public List<Restaurant> getRestaurantList (){
        return restaurantList;
    }

    public boolean addRestaurant (Restaurant restaurant){
        return restaurantList.add(restaurant);
    }

    public boolean deleteRestaurant(Restaurant restaurant) {
        return restaurantList.remove(restaurant);
    }

}
