import { Component, OnInit } from '@angular/core';
import { Car } from '../Car/car';
import { CarService } from '../Service/car.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {
  cars: Car[] = [];

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.loadCars();
  }

  loadCars(): void {
    this.carService.getAllcars().subscribe((data: Car[]) => {
      this.cars = data;
    });
  }

  deleteCar(car: Car): void {
    if (!car || car.id === undefined) {
      console.error('Car ID is undefined');
      return;
    }

    if (confirm('Are you sure you want to delete this car?')) {
      this.carService.deleteCar(car.id).subscribe(() => {
        this.carService.updateCarsAfterDelete(car.id || 0).subscribe(cars => {
          this.cars = cars;
        });
      });
    }
  }

}
