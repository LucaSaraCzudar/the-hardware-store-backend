package com.eureka.products.repository;

import com.eureka.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameLikeIgnoreCase(String name);
}
