package com.example.garageApp.service;

import java.util.List;

import com.example.garageApp.model.Car;

public interface GarageService {
	
	List<Car> getAllCars();

	Car getCarById(Long id);

	Car createCar(Car car);

	void deleteCar(Long id);
	
	Car updateCar(Long id, Car updatedCar);

}