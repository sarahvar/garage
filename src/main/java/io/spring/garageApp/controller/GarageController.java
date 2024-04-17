package io.spring.garageApp.controller;

import io.spring.garageApp.model.Car;
import io.spring.garageApp.service.GarageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GarageController {
    @Autowired
private GarageService garageService;
    @RequestMapping("/cars")
    public List<Car> getCars() {
        return garageService.getCars();
    }

    @RequestMapping("/car/{id}")
    public Car getCar(@PathVariable long id){
        return garageService.getCar(id);}
}
