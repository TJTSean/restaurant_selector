package com.selector.restaurant.restaurant;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;
    private String name;
    private String address;
    private String submitted_By;

    public Restaurant(String name, String address, String submitted_By) {
        this.name = name;
        this.address = address;
        this.submitted_By = submitted_By;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return restaurantId;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Restaurant setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getSubmitted_By() {
        return submitted_By;
    }

    public Restaurant setSubmitted_By(String submitted_By) {
        this.submitted_By = submitted_By;
        return this;
    }
}
