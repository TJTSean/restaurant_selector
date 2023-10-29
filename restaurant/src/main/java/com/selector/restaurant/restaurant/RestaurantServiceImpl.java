package com.selector.restaurant.restaurant;

import com.selector.restaurant.common.RestaurantConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    Logger logger = LogManager.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepo restaurantRepo;

    /**
     * Sends restaurant to be stored in database
     * @throws IllegalStateException if Restaurant can be found in database
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
            throw new IllegalStateException(RestaurantConstants.DUPLICATE_RESTAURANT);

        return restaurantRepo.save(restaurant);
        //return restaurantRepo.add(restaurant);
    }

    /**
     * Returns a random Restaurant from database
     * @throws IllegalStateException if no Restaurants can be found in database
     * @return Restaurant
     */
    @Override
    public Restaurant getAtRandom() {
        logger.info("[Retrieving restaurant from pool at random]");
        if(getList().isEmpty())
            throw new IllegalStateException(RestaurantConstants.NO_RESTAURANT);

        ArrayList<Restaurant> list = new ArrayList<>(getList());
        int index = new Random().nextInt(list.size());
        Long value = list.get(index).getId();

        return restaurantRepo.findById(value).get();
    }

    /**
     * Retrieve all restaurants stored in database
     * @return
     */
    @Override
    public Collection<Restaurant> getList() {
        return (Collection<Restaurant>) restaurantRepo.findAll();
    }

    @Override
    public void clearRepo() {
        restaurantRepo.deleteAll();
    }
}
