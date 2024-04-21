import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GarageService } from './garage.service';
import { OnInit } from '@angular/core';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[GarageService]
})
export class AppComponent implements OnInit{
  title = 'garage';
  cars: Object
  constructor(private garageService:GarageService){}

  ngOnInit(){
      console.log("On init......")
      this.garageService.getCars().subscribe(datas => {
        this.cars = datas
      })
  }
}
