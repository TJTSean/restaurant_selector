import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantResultComponent } from './restaurant-result.component';

describe('RestaurantResultComponent', () => {
  let component: RestaurantResultComponent;
  let fixture: ComponentFixture<RestaurantResultComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RestaurantResultComponent]
    });
    fixture = TestBed.createComponent(RestaurantResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
