package com.arya.belajar.tdd.controller;

import com.arya.belajar.tdd.domain.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping("/{name}")
    public Car getCar(@PathVariable String name){
        return null;
    }
}