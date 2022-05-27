package com.products.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[2].name", Matchers.is("ROCCAT Pyro")));

    }

    @Test
    void findProductsByName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/filters?name=logitech"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Logitech G502")))
                .andExpect(jsonPath("$[1].name", Matchers.is("Logitech G502 Lightspeed")));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/filters?name=lightspeed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Logitech G502 Lightspeed")));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/filters?name=cheese"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/filters?name="))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));
    }
}
