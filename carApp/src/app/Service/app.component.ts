import { Component } from '@angular/core';
import { CarService } from '../Service/car.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'carApp';
  constructor(private carService: CarService) { }

ngOnInit() {
  this.carService.getAllcars().subscribe(cars => {
    console.log(cars);
  });
}
}
