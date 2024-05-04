package com.example.garageApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.garageApp.exception.ResourceNotFoundException;
import com.example.garageApp.model.Car;
import com.example.garageApp.repository.GarageRepository;

@Service
public class GarageServiceImpl implements GarageService {

    @Autowired
    private GarageRepository garageRepository;

    @Override
    public List<Car> getAllCars() {
        return garageRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return garageRepository.findById(id).orElse(null);
    }

    @Override
    public Car add(Car car) {
        return garageRepository.save(car);
    }

    @Override
public void deleteCar(Long id) {
    // Vérifiez d'abord si la voiture existe
    Car car = garageRepository.findById(id).orElse(null);

    // Supprimez la voiture
    if (car != null) {
        garageRepository.delete(car);
    }
}

@Override
public Car updateCar(Long id, Car updatedCar) {
    // Récupérez la voiture avec l'identifiant spécifié s'il existe, sinon retournez null
    Car car = garageRepository.findById(id).orElse(null);

    // Si la voiture n'existe pas, lancez une exception ResourceNotFoundException
    if (car == null) {
        throw new ResourceNotFoundException("Car not found with id: " + id);
    }

    // Mettez à jour les informations de la voiture
    car.setBrand(updatedCar.getBrand());
    car.setModel(updatedCar.getModel());
    car.setYear(updatedCar.getYear());
    car.setColor(updatedCar.getColor());

    // Sauvegardez et retournez la voiture mise à jour
    return garageRepository.save(car);
}

}
