package com.jimmy.link.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getNbPOIs() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/poi?lon=-7&lat=6.5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("2")));
    }

    @Test
    public void getDensestPOIs() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/poi/densest/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[\"[min_lat: -2.5; max_lat: -2.0; min_lon: 38.0; max_lon: 38.5]\",\"[min_lat: 6.5; max_lat: 7.0; min_lon: -7.0; max_lon: -6.5]\"]")));
    }
}
