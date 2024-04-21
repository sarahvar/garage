package com.example.garageApp.service;

import com.example.garageApp.model.Car;
import com.example.garageApp.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GarageService {
    // creer les methodes CRUD
    // ajouter les methodes pour les requetes

    @Autowired
    private GarageRepository garageRepository;
    static private  ArrayList<Car> cars = new ArrayList<>(Arrays.asList(
      
            new Car(1,"R21", "Renault", 1988, "BLUE"),
            new Car(2,"Clio1", "Renault", 1993, "RED"),
            new Car(3,"Mustang", "Ford", 1967, "YELLOW"),
            new Car(4,"Sierra25", "GMC", 1976, "BROWN"),
            new Car(5,"Celica", "Toyota", 1989, "RED") 
    ));

    public List<Car> getCars() {
        // sans le repository CRUD SIMPLE
        // return cars;

        // avec le repository
        List<Car> cars = new ArrayList<>();
        garageRepository.findAll().forEach(car -> cars.add(car));
        return cars;
    }

    public Car getCar(long id) {
        // sans le repository CRUD SIMPLE
        // return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);

        // avec le repository
        return garageRepository.findById(id).orElse(null);
    }

    public void deleteCar(long id) {
        // sans le repository CRUD SIMPLE
        //cars.removeIf(car -> car.getId() == id);
        //System.out.println("Voiture supprimée");

        // avec le repository
        garageRepository.deleteById(id);
        System.out.println("Voiture supprimée");

    }


    public void add(Car car) {
        // sans le repository CRUD SIMPLE
        //cars.add(car);
        //System.out.println("Voiture ajoutée");

        // avec le repository
        garageRepository.save(car);
        System.out.println("Voiture ajoutée");
    }


    public void updateCar(Car car, long id) {

        // sans le repository CRUD SIMPLE

        //cars.forEach(car1 -> {
           // if (car1.getId() == id) {
              //  car1.setBrand(car.getBrand());
              //  car1.setModel(car.getModel());
            // car1.setYear(car.getYear());
           // car1.setColor(car.getColor());}});
        //System.out.println("Voiture mise à jour");

        // avec le repository
        garageRepository.save(car);
        System.out.println("Voiture mise à jour");
    }
}
