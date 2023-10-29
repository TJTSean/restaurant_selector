import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { RestaurantService } from './service/restaurant.service';
import { AppState } from './interface/app-state';
import { Observable } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  [x: string]: any;
  title = 'selectorapp';
  appState$!: Observable<AppState<RestaurantService>>;
  constructor(
    private restaurantService: RestaurantService,
    private dialog: MatDialog
    ) {}

  ngOnInit(): void {}

  @ViewChild('inputForm', { static: true })
  inputForm!: TemplateRef<any>;
  openDialogWithoutRef() {
    this.dialog.open(this.inputForm);
  }
  addRestaurantModal() {
    this.dialog.open(this.inputForm);
  }

  restaurant = {
    name: "KFC",
    address: "Street 123",
    submitted_By: "Mary"
  };

  onSubmit() {
    console.log(JSON.stringify(this.restaurant, undefined, 2));
  }
}
