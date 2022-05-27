package com.products.util;

import com.products.constants.ProductImage;
import com.products.enums.ProductType;
import com.products.models.Product;
import com.products.repository.ProductRepository;
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
            log.info("Preloading " + repository.save(new Product("Logitech G502", 52.50F, ProductType.MOUSE,
                    """
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                            Proin aliquam risus eu dignissim euismod.
                            Ut cursus mi nec congue feugiat.
                            Curabitur faucibus arcu id quam laoreet dapibus.
                            Sed ullamcorper enim et metus volutpat accumsan.
                            Vestibulum eget elit et neque imperdiet viverra vitae at felis.""", ProductImage.G502)));
            log.info("Preloading " + repository.save(new Product("Logitech G502 Lightspeed", 91F, ProductType.MOUSE,
                    """
                            Suspendisse fermentum risus nec ornare egestas.
                            Integer non turpis viverra sapien iaculis congue ut vitae tellus.
                            Pellentesque tincidunt justo ut lectus accumsan, ut maximus elit elementum.
                            Curabitur eget nulla commodo felis elementum aliquam.""", ProductImage.G502L)));
            log.info("Preloading " + repository.save(new Product("ROCCAT Pyro", 104.15F, ProductType.KEYBOARD,
                    """
                            Phasellus interdum nunc sit amet nisl venenatis volutpat.
                            Pellentesque blandit augue quis tincidunt eleifend.
                            Sed semper dolor ut laoreet aliquam.
                            Praesent aliquam quam eget justo placerat ultrices.
                            Vestibulum ac leo vitae risus cursus fringilla sed vitae felis.
                            In id velit in ante auctor facilisis.""", ProductImage.Pyro)));
            log.info("Preloading " + repository.save(new Product("Corsair Vengeance 16GB DDR4 3200MHz", 68F, ProductType.RAM,
                    """
                            Etiam sit amet purus eget neque hendrerit suscipit.
                            Curabitur id metus at nisi ultrices pharetra non a neque.
                            Quisque dapibus neque at enim porttitor, ut tincidunt magna pharetra.
                            Aliquam vel justo sit amet neque bibendum placerat.
                            In nec diam pharetra, tempus turpis ac, euismod diam.""", ProductImage.Corsair)));
            log.info("Preloading " + repository.save(new Product("Intel Core i7-12700K 2.70GHz", 425F, ProductType.CPU,
                    """
                            Etiam ac dolor et arcu suscipit gravida.
                            Fusce semper dui a condimentum scelerisque.
                            Nulla pulvinar augue ac turpis ultricies tempus sed vitae lacus.
                            Praesent in diam quis quam porta convallis a quis augue.
                            Quisque semper lorem at interdum sodales.""", ProductImage.i7)));
        };
    }
}
