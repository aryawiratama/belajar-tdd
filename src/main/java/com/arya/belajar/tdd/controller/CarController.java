package com.arya.belajar.tdd.controller;

import com.arya.belajar.tdd.CarNotFoundException;
import com.arya.belajar.tdd.domain.Car;
import com.arya.belajar.tdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{name}")
    public Car getCar(@PathVariable String name){
        return carService.findCar(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void carNotFoundHandler(CarNotFoundException ex){

    }
}