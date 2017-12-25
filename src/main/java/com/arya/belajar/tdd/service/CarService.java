package com.arya.belajar.tdd.service;

import com.arya.belajar.tdd.CarNotFoundException;
import com.arya.belajar.tdd.domain.Car;
import com.arya.belajar.tdd.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findCar(String name) {
        Car car = carRepository.findByName(name);
        if(car==null)
            throw new CarNotFoundException();
        return car;
    }
}
