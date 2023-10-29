package com.selector.restaurant.restaurant;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class RestaurantRepoImpl {

    private static final List<Restaurant> restaurants = new ArrayList<>();
    //@Override
    public Optional<Restaurant> add(Restaurant restaurant) {
        restaurants.add(restaurant);
        return restaurants.stream()
                .filter(r -> r.equals(restaurant))
                .findFirst();
    }

    //@Override
    public Restaurant get(int index) {
        return restaurants.get(index);
    }

    //@Override
    public Collection<Restaurant> getList() {
        return restaurants;
    }

}
