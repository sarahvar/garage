import { Component, OnInit } from '@angular/core';
import { Car } from '../Car/car';
import { CarService } from '../Service/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {
  cars: Car[] = [];

  constructor(private carService:  CarService, private router: Router) {}

  ngOnInit(): void {
    this.carService.getAllcars().subscribe((data: Car[]) => {
      this.cars = data;
    });
  }
  deleteCar(id: number | undefined): void {
    if (id !== undefined) {
      this.carService.deleteCar(id).subscribe(() => {
        // Update the car list or navigate to another view after successful deletion
      });
    } else {
      console.error('Car ID is undefined');
    }
  }

}
