import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CarService } from '../Service/car.service';

@Component({
  selector: 'app-car-edit',
  templateUrl: './car-edit.component.html',
  styleUrls: ['./car-edit.component.css']
})
export class CarEditComponent {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private carService: CarService
  ) { }

  car: any;

  ngOnInit(): void {
    const carId = this.route.snapshot.paramMap.get('id');
    if (carId) {
      const carIdNumber = parseInt(carId, 10);
      this.carService.getCarById(carIdNumber).subscribe((car) => {
        this.car = car;
      });
    } else {
      // Handle the case when the carId is null
    }
  }
  onSubmit(): void {
    this.carService.updateCar(this.car).subscribe(() => {
      this.router.navigate(['/cars']);
    });
  }

}
