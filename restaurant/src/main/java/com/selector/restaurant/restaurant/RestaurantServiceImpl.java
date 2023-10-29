package com.selector.restaurant.restaurant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.Random;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    Logger logger = LogManager.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepo restaurantRepo;

    /**
     * Sends restaurant to RestaurantRepo
     * @param restaurant
     * @return
     */
    @Override
    public Restaurant add(@RequestBody Restaurant restaurant) {
        logger.info("[Adding restaurant: {}]", restaurant.getName());

        /**
         * Find if the name of the restaurant has been submitted before
         */
        if(getList().stream()
                .filter(r -> r.getName().equals(restaurant.getName()))
                .findFirst()
                .orElse(null) != null)
            throw new IllegalStateException("Restaurant Name has been previously submitted");

        return restaurantRepo.save(restaurant);
        //return restaurantRepo.add(restaurant);
    }

    @Override
    public Restaurant getAtRandom() {
        logger.info("[Retrieving restaurant from pool at random]");
        if(getList().isEmpty())
            throw new IllegalStateException("No restaurant names have been submitted");
        int index = new Random().nextInt(getList().size()) + 1;
        Long value = Integer.toUnsignedLong(index);
        return restaurantRepo.findById(value).get();
    }

    @Override
    public Collection<Restaurant> getList() {
        return (Collection<Restaurant>) restaurantRepo.findAll();
    }
}
