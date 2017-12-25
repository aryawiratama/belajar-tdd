package com.arya.belajar.tdd.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCar_ShouldReturnCar()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/jazz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Jazz"))
                .andExpect(jsonPath("type").value("City Car"));
    }
}
