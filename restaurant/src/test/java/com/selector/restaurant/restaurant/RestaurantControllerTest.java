package com.selector.restaurant.restaurant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selector.restaurant.AbstractTest;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RestaurantControllerTest {

    @Autowired
    private RestaurantController restaurantController;

    @Autowired
    WebApplicationContext webApplicationContext;

    private String RESTAURANT_NAME_1 = "Test Restaurant 1";
    private String RESTAURANT_ADDRESS_1 = "Test Address 1";
    private String SUBMIT_1 = "Name 1";
    private String RESTAURANT_NAME_2 = "Test Restaurant 2";
    private String RESTAURANT_ADDRESS_2 = "Test Address 2";
    private String SUBMIT_2 = "Name 2";

    @BeforeEach
    protected void setUp() {
        Restaurant product = new Restaurant(RESTAURANT_NAME_1, RESTAURANT_ADDRESS_1, SUBMIT_1);
        //restaurantController.addRestaurant(product);
    }

    @Test
    public void itShouldReturnSuccess() {

        String uri = "/add";
        Restaurant product = new Restaurant(RESTAURANT_NAME_2, RESTAURANT_ADDRESS_2, SUBMIT_2);
        //ResponseEntity responseEntity = restaurantController.addRestaurant(product);

        //assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void itShouldReturnMessageIndicatingDuplicate() {

        String uri = "/add";
        Restaurant product = new Restaurant(RESTAURANT_NAME_1, RESTAURANT_ADDRESS_1, SUBMIT_1);
        //ResponseEntity<Response> responseEntity = restaurantController.addRestaurant(product);

        //assertThat(responseEntity.getBody().getMessage()).isEqualTo("Restaurant Name has been previously submitted");
    }
}
