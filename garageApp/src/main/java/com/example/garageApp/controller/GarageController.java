// CarController.java

package com.example.garageApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.garageApp.model.Car;
import com.example.garageApp.service.GarageService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class GarageController {

    @Autowired
    private GarageService garageService;
    
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = garageService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = garageService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    
    @PostMapping("/carCreate")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = garageService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car updatedCar) {
        Car car = garageService.updateCar(id, updatedCar);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        garageService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
