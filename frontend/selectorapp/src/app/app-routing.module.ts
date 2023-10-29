import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RestaurantResultComponent } from './restaurant-result/restaurant-result.component';
import { RestaurantFormComponent } from './restaurant-form/restaurant-form.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: 'result', component: RestaurantResultComponent },
  { path: 'addRestaurant', component: RestaurantFormComponent },
  { path: 'home', component: AppComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }