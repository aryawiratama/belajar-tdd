package com.arya.belajar.tdd.controller;

import com.arya.belajar.tdd.CarNotFoundException;
import com.arya.belajar.tdd.domain.Car;
import com.arya.belajar.tdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_ShouldReturnCar()throws Exception{
        given(carService.findCar(anyString())).willReturn(Car.builder().name("Jazz").type("City Car").build());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/jazz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Jazz"))
                .andExpect(jsonPath("type").value("City Car"));
    }

    @Test
    public void getCar_NotFound()throws Exception{
        given(carService.findCar(anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/jazz"))
                .andExpect(status().isNotFound());
    }
}
