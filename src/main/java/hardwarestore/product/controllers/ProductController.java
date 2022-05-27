package hardwarestore.product.controllers;

import java.util.List;

import hardwarestore.product.models.Product;
import hardwarestore.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/products/filters")
    @ResponseBody
    public List<Product> filterProductsByName(@RequestParam String name) {
        return repository.findByNameLikeIgnoreCase("%" + name + "%");
    }
}
