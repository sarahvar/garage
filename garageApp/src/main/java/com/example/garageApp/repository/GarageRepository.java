package com.example.garageApp.repository;

import com.example.garageApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GarageRepository extends JpaRepository<Car, Long> {
}
