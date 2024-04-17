package io.spring.garageApp.controller;

import io.spring.garageApp.model.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GarageController {

    @RequestMapping("/car")
    public Car getCar() {
        Car myCar = new Car("R21", "Renault", 1988, Car.Color.RED);
        return myCar;
    }
}
