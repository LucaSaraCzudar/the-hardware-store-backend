package com.eureka.cart.controllers;

import com.eureka.cart.exceptions.CartItemNotFoundException;
import com.eureka.cart.models.CartItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.Objects;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        CartItem cartItem = new CartItem("id", "item name", 10.5F);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/cart-items")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cartItem));

        this.mockMvc.perform(mockRequest);
    }

    @Test
    void addCartItem() throws Exception {
        CartItem cartItem = new CartItem("id2", "item name2", 10.5F);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/cart-items")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cartItem));

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    void getAllCartItems() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/cart-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        CartItem cartItem = new CartItem("id2", "item name2", 10.5F);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/cart-items")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cartItem));

        this.mockMvc.perform(mockRequest);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/cart-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("item name")));
    }

    @Test
    void getCartItem() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/cart-items/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(4)))
                .andExpect(jsonPath("$.name", Matchers.is("item name")));

        Assertions.assertThrows(NestedServletException.class, () -> {
            this.mockMvc.perform(MockMvcRequestBuilders
                            .get("/cart-items/random-id"))
                    .andExpect(status().is5xxServerError())
                    .andExpect(result -> assertTrue(result.getResolvedException() instanceof CartItemNotFoundException))
                    .andExpect(result -> assertEquals(Objects.requireNonNull(result.getResolvedException()).getMessage(), "Could not find product random-id"));
        });
    }

    @Test
    void updateCartItem() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/cart-items/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(5)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(4)))
                .andExpect(jsonPath("$.quantity", Matchers.is(5)));

        Assertions.assertThrows(NestedServletException.class, () -> {
            this.mockMvc.perform(MockMvcRequestBuilders
                            .put("/cart-items/random-id")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(this.mapper.writeValueAsString(5)))
                    .andExpect(status().is5xxServerError())
                    .andExpect(result -> assertTrue(result.getResolvedException() instanceof CartItemNotFoundException))
                    .andExpect(result -> assertEquals(Objects.requireNonNull(result.getResolvedException()).getMessage(), "Could not find product random-id"));
        });

        Assertions.assertThrows(NestedServletException.class, () -> {
            this.mockMvc.perform(MockMvcRequestBuilders
                            .put("/cart-items/id")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(this.mapper.writeValueAsString(-1)))
                    .andExpect(status().is5xxServerError());
        });
    }

    @Test
    void deleteCartItem() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/cart-items/id"))
                .andExpect(status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/cart-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
