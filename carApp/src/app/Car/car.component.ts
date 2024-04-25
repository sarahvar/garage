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

  deleteCar(id: number): void {
    if (confirm('Are you sure you want to delete this car?')) {
      this.carService.deleteCar(id).subscribe(() => {
        this.loadCars(); // Rechargez la liste des voitures après la suppression
      });
    }
  }
}
