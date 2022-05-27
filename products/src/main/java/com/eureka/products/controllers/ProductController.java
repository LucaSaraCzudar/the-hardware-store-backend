package com.eureka.products.controllers;

import java.util.List;

import com.eureka.products.models.Product;
import com.eureka.products.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/filters")
    @ResponseBody
    public List<Product> filterProductsByName(@RequestParam String name) {
        return repository.findByNameLikeIgnoreCase("%" + name + "%");
    }
}
