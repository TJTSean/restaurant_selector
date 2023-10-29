import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../interface/restaurant';
import { RestaurantService } from '../service/restaurant.service';
import { RestaurantAppResponse } from '../interface/custom-response';

@Component({
  selector: 'app-restaurant-result',
  templateUrl: './restaurant-result.component.html',
  styleUrls: ['./restaurant-result.component.css']
})
export class RestaurantResultComponent implements OnInit {

  restaurant: Restaurant;
  responseEntity: RestaurantAppResponse;
  retrieveStatus: string;

  constructor(private restaurantService: RestaurantService) {}

  ngOnInit() {
    this.restaurantService.getRandomRestaurant().subscribe(restaurantRes => {
      this.responseEntity = restaurantRes;
      console.log(this.responseEntity.message);
      if(restaurantRes.data == null) {
        this.restaurant = new Restaurant();
        //this.restaurant.name = this.responseEntity.message;
        this.retrieveStatus = this.responseEntity.message
      } else {
        this.retrieveStatus = "Chosen Restaurant is:"
        this.restaurant = this.responseEntity.data["retrieved"];
      }
      console.log(this.restaurant.name)
    })
    
  }

  onClick() {
    this.ngOnInit();
    };
}
