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
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = garageService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Car car = garageService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Car> add(@RequestBody Car car) {
        garageService.add(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car updatedCar) {
        garageService.updateCar(id, updatedCar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        garageService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
