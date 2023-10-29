package com.selector.restaurant.restaurant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> add(Restaurant restaurant);
    Restaurant get(int index);
    Collection<Restaurant> getList();
}
