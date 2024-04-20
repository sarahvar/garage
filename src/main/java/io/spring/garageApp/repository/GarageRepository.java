package io.spring.garageApp.repository;

import org.springframework.data.repository.CrudRepository;
import io.spring.garageApp.model.Car;

public interface GarageRepository extends CrudRepository<Car, Long> {

    
}