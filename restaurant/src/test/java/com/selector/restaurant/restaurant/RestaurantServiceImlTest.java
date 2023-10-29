package com.selector.restaurant.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RestaurantServiceImlTest {

    @Autowired
    private RestaurantService restaurantService;

    @BeforeEach
    public void setUp() {
        Restaurant restaurant = new Restaurant("Test Restaurant 1", "Test Address 1", "Name 1");
        //restaurantService.add(restaurant);
    }

    @Test
    public void shouldReturnSameRestaurant() {
        //Optional<Restaurant> restaurant = restaurantService.add(new Restaurant("Test Restaurant 2", "Test Address 2", "Name 2"));
        //assertThat(restaurant.get().getName()).isEqualTo("Test Restaurant 2");
    }

    @Test
    public void shouldReturnFullList() {
        //Optional<Restaurant> restaurant = restaurantService.add(new Restaurant("Test Restaurant 2", "Test Address 2", "Name 2"));

        List<Restaurant> givenList = new ArrayList<>();
        givenList.add(new Restaurant("Test Restaurant 1", "Test Address 1", "Name 1"));
        givenList.add(new Restaurant("Test Restaurant 2", "Test Address 2", "Name 2"));
        Collection<Restaurant> givenCollection = givenList;

        //Collection<Restaurant> restaurants = restaurantService.getList();

        //assertThat(restaurants).isEqualTo(givenCollection);
    }

}
