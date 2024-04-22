import { Component, OnInit } from '@angular/core';
import { Car } from '../Car/car';
import { CarService } from '../Service/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car-create',
  templateUrl: './car-create.component.html',
  styleUrls: ['./car-create.component.css']
})
export class CarCreateComponent implements OnInit {
  car: Car = {};

  constructor(private carService: CarService, private router: Router) { }

  ngOnInit(): void {
  }

  createCar(): void {
    this.carService.createCar(this.car).subscribe(createdCar => {
      this.router.navigate(['/cars']);
      // Handle the response or navigate to another view after successful creation
    });
  }
}
