package com.arya.belajar.tdd.repository;

import com.arya.belajar.tdd.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testFindCarByName_ShouldReturnCar()throws Exception{
        carRepository.save(Car.builder().name("jazz").type("City Car").build());
        Car car = carRepository.findByName("jazz");
        assertThat(car.getName(), equalToIgnoringCase("jazz"));
        assertThat(car.getType(), equalToIgnoringCase("City Car"));
    }
}