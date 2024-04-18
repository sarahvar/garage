package io.spring.garageApp.controller;

import io.spring.garageApp.model.Car;
import io.spring.garageApp.service.GarageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

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

  
        @RequestMapping(method = RequestMethod.DELETE, value = "/car/{id}")
        public void deleteCar(@PathVariable long id){
            garageService.deleteCar(id);
        }

        @RequestMapping(method = RequestMethod.POST, value = "/cars")
        public void addCar(@RequestBody Car car) {
            garageService.addCar(car);
        } 
        }  

