import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from '../Car/car';
import { switchMap } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CarService {
  private apiUrl = 'http://localhost:8080/cars';

  constructor(private http: HttpClient) { }

  getAllcars(): Observable<Car[]> {
    return this.http.get<Car[]>(this.apiUrl);
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.apiUrl}/${id}`);
  }

  createCar(car: Car): Observable<Car> {
    return this.http.post<Car>(this.apiUrl, car);
  }

  updateCar(car: Car): Observable<Car> {
    return this.http.put<Car>(`${this.apiUrl}/${car.id}`, car);
  }

  deleteCar(id: number): Observable<void> {
    const url = `${this.apiUrl}/delete/${id}`; // Utilisez l'endpoint de suppression approprié
    return this.http.delete<void>(url);
  }

  // Fonction pour mettre à jour les voitures après une suppression
  updateCarsAfterDelete(id: number): Observable<Car[]> {
    // Supprimez la voiture avec l'ID spécifié puis récupérez la liste mise à jour des voitures
    return this.deleteCar(id).pipe(
      switchMap(() => this.getAllcars())
    );
  }
}

