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
    public Car createCar(Car car) {
        return garageRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        garageRepository.deleteById(id);
    }

	@Override
	public Car updateCar(Long id, Car updatedCar) {
        Car car = garageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setColor(updatedCar.getColor());
        return garageRepository.save(car);
	}
}
