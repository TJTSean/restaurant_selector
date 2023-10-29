package com.selector.restaurant;

import com.selector.restaurant.restaurant.Restaurant;
import com.selector.restaurant.restaurant.RestaurantRepo;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaRepositories("com")
@ComponentScan("com")
@EntityScan("com")
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RestaurantRepo restaurantRepo) {
		return args -> {
			restaurantRepo.add(new Restaurant("123", "Address 1", "Name"));
			restaurantRepo.add(new Restaurant("McDonald", "Address 2", "Name 1"));
		};
	}
}
