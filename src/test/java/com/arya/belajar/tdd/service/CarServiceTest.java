package com.arya.belajar.tdd.service;

import com.arya.belajar.tdd.CarNotFoundException;
import com.arya.belajar.tdd.domain.Car;
import com.arya.belajar.tdd.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.smartcardio.CardNotPresentException;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setup()throws Exception{
        carService = new CarService(carRepository);
    }

    @Test
    public void testFindCar_ShouldReturnCar(){
        given(carRepository.findByName("jazz")).willReturn(Car.builder().name("Jazz").type("City Car").build());
        Car car = carService.findCar("jazz");

        assertThat(car.getName(), equalToIgnoringCase("Jazz"));
        assertThat(car.getType(), equalToIgnoringCase("City Car"));
    }

    @Test(expected = CarNotFoundException.class)
    public void testFindCar_CarNotFound(){
        given(carRepository.findByName("taruna")).willThrow(new CarNotFoundException());

        Car car = carService.findCar("taruna");
        assertThat(car, null);
    }
}