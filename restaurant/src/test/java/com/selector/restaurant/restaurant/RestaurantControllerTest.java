package com.selector.restaurant.restaurant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selector.restaurant.AbstractTest;
import com.selector.restaurant.common.RestaurantConstants;
import com.selector.restaurant.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RestaurantControllerTest {

    @Autowired
    private RestaurantController restaurantController;

    @Autowired
    private RestaurantService restaurantService;

    private final String RESTAURANT_NAME_1 = "Test Restaurant 1";
    private final String RESTAURANT_ADDRESS_1 = "Test Address 1";
    private final String SUBMIT_1 = "Name 1";
    private final String RESTAURANT_NAME_2 = "Test Restaurant 2";
    private final String RESTAURANT_ADDRESS_2 = "Test Address 2";
    private final String SUBMIT_2 = "Name 2";

    @BeforeEach
    protected void setUp() {
        restaurantService.clearRepo();
    }

    @Test
    public void itShouldReturnSuccess() {
        restaurantController.addRestaurant(new Restaurant(RESTAURANT_NAME_1, RESTAURANT_ADDRESS_1, SUBMIT_1));
        ResponseEntity<Response> responseEntity = restaurantController.addRestaurant(new Restaurant(RESTAURANT_NAME_2, RESTAURANT_ADDRESS_2, SUBMIT_2));
        Restaurant submitted = (Restaurant) responseEntity.getBody().getData().get(RestaurantConstants.SUBMITTED);

        assertThat(submitted.getName()).isEqualTo(RESTAURANT_NAME_2);
    }

    @Test
    public void itShouldReturnMessageIndicatingDuplicate() {
        restaurantController.addRestaurant(new Restaurant(RESTAURANT_NAME_1, RESTAURANT_ADDRESS_1, SUBMIT_1));
        ResponseEntity<Response> responseEntity = restaurantController.addRestaurant(new Restaurant(RESTAURANT_NAME_1, RESTAURANT_ADDRESS_1, SUBMIT_1));
        Response returned = (Response) responseEntity.getBody();

        assertThat(returned.getMessage()).isEqualTo(RestaurantConstants.DUPLICATE_RESTAURANT);
    }

    @Test
    public void itShouldReturnMessageIndicatingNoRestaurant() {
        ResponseEntity<Response> responseEntity = restaurantController.getAtRandom();
        Response returned = (Response) responseEntity.getBody();

        assertThat(returned.getMessage()).isEqualTo(RestaurantConstants.NO_RESTAURANT);
    }

    @Test
    public void itShouldReturnRandomRestaurant() {
        restaurantController.addRestaurant(new Restaurant(RESTAURANT_NAME_1, RESTAURANT_ADDRESS_1, SUBMIT_1));
        restaurantController.addRestaurant(new Restaurant(RESTAURANT_NAME_2, RESTAURANT_ADDRESS_2, SUBMIT_2));

        ArrayList<String> list = new ArrayList<>();
        list.add(RESTAURANT_NAME_1);
        list.add(RESTAURANT_NAME_2);

        for(int i = 0; i < 10; i++) {
            ResponseEntity<Response> responseEntity = restaurantController.getAtRandom();
            Response response = (Response) responseEntity.getBody();
            Restaurant retrieved = (Restaurant) response.getData().get(RestaurantConstants.RETRIEVED);

            //Restaurant retrieved = (Restaurant) restaurantController.getAtRandom().getBody().getData().get(RestaurantConstants.RETRIEVED);
            assertThat(retrieved.getName()).isIn(list);
        }
    }
}
