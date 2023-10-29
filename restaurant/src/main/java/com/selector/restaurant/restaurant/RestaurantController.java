package com.selector.restaurant.restaurant;

import com.selector.restaurant.common.RestaurantConstants;
import com.selector.restaurant.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @PostMapping(path = "/add", consumes = {"application/json"})
    public ResponseEntity<Response> addRestaurant(@RequestBody Restaurant restaurant) {
        try {
            return ResponseEntity.ok(
                    new Response.ResponseBuilder()
                            .setTimestamp(LocalDateTime.now())
                            .setStatus(HttpStatus.OK)
                            .setStatusCode(HttpStatus.OK.value())
                            .setData(Map.of(RestaurantConstants.SUBMITTED, restaurantService.add(restaurant)))
                            .setMessage(RestaurantConstants.SUBMITTED_SUCCESS)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new Response.ResponseBuilder()
                            .setTimestamp(LocalDateTime.now())
                            .setStatus(HttpStatus.OK)
                            .setStatusCode(HttpStatus.OK.value())
                            .setMessage(e.getMessage())
                            .build()
            );
        }
    }


    @GetMapping("/randomRetrieval")
    public ResponseEntity<Response> getAtRandom() {
        try {
            return ResponseEntity.ok(
                    new Response.ResponseBuilder()
                            .setTimestamp(LocalDateTime.now())
                            .setStatus(HttpStatus.OK)
                            .setStatusCode(HttpStatus.OK.value())
                            .setMessage(RestaurantConstants.RETRIEVED_SUCCESS)
                            .setData(Map.of(RestaurantConstants.RETRIEVED, restaurantService.getAtRandom()))
                            .build()
            );
        } catch (IllegalStateException e) {
            return ResponseEntity.ok(
                    new Response.ResponseBuilder()
                            .setTimestamp(LocalDateTime.now())
                            .setStatus(HttpStatus.OK)
                            .setStatusCode(HttpStatus.OK.value())
                            .setMessage(e.getMessage())
                            .build()
            );
        }
    }

    /**
     * Check if there is any restaurant in storage
     *  - true if list is empty
     *  - false if list is not empty
     * @return
     */
    private Boolean listIsEmpty() {
        return restaurantService.getList().isEmpty();
    }
}
