package hardwarestore.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Logitech G502", 52.50F, ProductType.MOUSE, "example description", "example image")));
            log.info("Preloading " + repository.save(new Product("Logitech G502 Lightspeed", 91F, ProductType.MOUSE, "example description", "example image")));
            log.info("Preloading " + repository.save(new Product("ROCCAT Pyro", 104.15F, ProductType.KEYBOARD, "example description", "example image")));
            log.info("Preloading " + repository.save(new Product("Corsair Vengeance 16GB DDR4 3200MHz", 68F, ProductType.RAM, "example description", "example image")));
            log.info("Preloading " + repository.save(new Product("Intel Core i7-12700K 2.70GHz", 425F, ProductType.CPU, "example description", "example image")));
        };
    }
}