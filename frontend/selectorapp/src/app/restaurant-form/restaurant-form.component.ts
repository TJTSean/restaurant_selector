import { Component } from '@angular/core';
import { Restaurant } from '../interface/restaurant';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantService } from '../service/restaurant.service';
import { RestaurantAppResponse } from '../interface/custom-response';

@Component({
  selector: 'app-restaurant-form',
  templateUrl: './restaurant-form.component.html',
  styleUrls: ['./restaurant-form.component.css']
})
export class RestaurantFormComponent {

  restaurant!: Restaurant;
  hidediv:boolean=true;
  responseEntity: RestaurantAppResponse;
  submitstatus: string;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private restaurantService: RestaurantService) {
    this.restaurant = new Restaurant();
  }

  onSubmit() {
    this.restaurantService.addRestaurant(this.restaurant).subscribe(result => {
      this.responseEntity = result;
      console.log(this.responseEntity.message);
      if(result.data == null) {
        this.submitstatus = result.message;
      } else {
        this.submitstatus = "Success"
      }
      this.gotoUserList()
    });
  }

  gotoUserList() {
    //this.router.navigate(['/home']);
    this.restaurant = new Restaurant();
    //this.hidediv = false;
  }
}
