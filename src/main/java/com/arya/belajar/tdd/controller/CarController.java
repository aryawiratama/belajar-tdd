package com.arya.belajar.tdd.controller;

import com.arya.belajar.tdd.domain.Car;
import com.arya.belajar.tdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{name}")
    public Car getCar(@PathVariable String name){
        return carService.findCar(name);
    }
}