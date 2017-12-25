package com.arya.belajar.tdd.integration;

import com.arya.belajar.tdd.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetCar_ShouldReturnCar()throws Exception{
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/jazz", Car.class);
    }
}
