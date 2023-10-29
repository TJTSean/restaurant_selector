package com.selector.restaurant.restaurant;

import com.selector.restaurant.common.RestaurantConstants;
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

    private final String RESTAURANT_NAME_3 = "Test Restaurant 3";
    private final String RESTAURANT_ADDRESS_3 = "Test Address 3";
    private final String SUBMIT_3 = "Name 3";
    private final String RESTAURANT_NAME_4 = "Test Restaurant 4";
    private final String RESTAURANT_ADDRESS_4 = "Test Address 4";
    private final String SUBMIT_4 = "Name 4";

    @BeforeEach
    public void setUp() {
        restaurantService.clearRepo();
    }

    @Test
    public void shouldReturnSameRestaurant() {
        Restaurant submitted = restaurantService.add(new Restaurant(RESTAURANT_NAME_3, RESTAURANT_ADDRESS_3, SUBMIT_3));
        assertThat(submitted.getName()).isEqualTo(RESTAURANT_NAME_3);
    }

    @Test
    public void shouldThrowErrorWhenSubmittedBefore() {
        restaurantService.add(new Restaurant(RESTAURANT_NAME_3, RESTAURANT_ADDRESS_3, SUBMIT_3));
        try {
            restaurantService.add(new Restaurant(RESTAURANT_NAME_3, RESTAURANT_ADDRESS_3, SUBMIT_3));
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(RestaurantConstants.DUPLICATE_RESTAURANT);
        }
    }

    @Test
    public void shouldThrowErrorWhenNoneSubmitted() {
        try {
            restaurantService.getAtRandom();
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(RestaurantConstants.NO_RESTAURANT);
        }
    }

    @Test
    public void shouldReturnFullList() {
        restaurantService.add(new Restaurant(RESTAURANT_NAME_3, RESTAURANT_ADDRESS_3, SUBMIT_3));
        restaurantService.add(new Restaurant(RESTAURANT_NAME_4, RESTAURANT_ADDRESS_4, SUBMIT_4));

        List<Restaurant> givenList = new ArrayList<>();
        givenList.add(new Restaurant(RESTAURANT_NAME_3, RESTAURANT_ADDRESS_3, SUBMIT_3));
        givenList.add(new Restaurant(RESTAURANT_NAME_4, RESTAURANT_ADDRESS_4, SUBMIT_4));

        List<Restaurant> temp = new ArrayList<>(restaurantService.getList());

        assertThat(temp.containsAll(givenList)).isEqualTo(givenList.containsAll(temp));
    }

    @Test
    public void shouldReturnSameNumberAsSubmitted() {
        restaurantService.add(new Restaurant(RESTAURANT_NAME_3, RESTAURANT_ADDRESS_3, SUBMIT_3));
        restaurantService.add(new Restaurant(RESTAURANT_NAME_4, RESTAURANT_ADDRESS_4, SUBMIT_4));

        assertThat(restaurantService.getList().size()).isEqualTo(2);
    }

}
