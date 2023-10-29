import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { Restaurant } from '../interface/restaurant';
import { RestaurantAppResponse } from '../interface/custom-response';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private apiUrl = environment.apiUrl;
  //'http://localhost:80';
  constructor(private http: HttpClient) { }

  getRandomRestaurant(): Observable<RestaurantAppResponse> {
    return this.http.get<RestaurantAppResponse>(`${this.apiUrl}/randomRetrieval`)
  }

  addRestaurant(restaurant: Restaurant): Observable<RestaurantAppResponse> {
    return this.http.post<RestaurantAppResponse>(`${this.apiUrl}/add`, restaurant)
  }

  /*addRestaurant$ = (restaurant: Restaurant) => <Observable<Restaurant>>
  this.http.post<Restaurant>(`${this.apiUrl}/add`, restaurant)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );*/

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError (() => `Error encoutered: ${error.status}`)
  }
}
