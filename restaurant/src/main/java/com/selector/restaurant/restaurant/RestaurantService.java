package com.selector.restaurant.restaurant;

import java.util.Collection;
import java.util.Optional;

public interface RestaurantService {
    Restaurant add(Restaurant restaurant);
    Restaurant getAtRandom();
    Collection<Restaurant> getList();
    void clearRepo();
}
