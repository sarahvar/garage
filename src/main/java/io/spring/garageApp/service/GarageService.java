package io.spring.garageApp.service;

import java.util.ArrayList;
import java.util.Arrays;

import io.spring.garageApp.model.Car;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GarageService {
    
    static private ArrayList<Car> cars = new ArrayList<>(Arrays.asList(
        new Car(1,"R21", "Renault", 1988, Car.Color.BLUE),
        new Car(2,"Clio1", "Renault", 1993, Car.Color.RED),
        new Car(3,"Mustang", "Ford", 1967, Car.Color.YELLOW),
        new Car(4,"Sierra25", "GMC", 1976, Car.Color.BROWN),
        new Car(5,"Celica", "Toyota", 1989, Car.Color.RED)        
    ));

    public List<Car> getCars() {
        return cars;
    }
    public Car getCar(long id) {
        return cars.stream()
                   .filter(car -> car.getId() == id)
                   .findFirst()
                   .orElse(null);
    }
}