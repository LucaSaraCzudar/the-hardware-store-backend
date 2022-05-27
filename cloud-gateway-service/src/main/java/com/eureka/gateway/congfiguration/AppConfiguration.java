package com.eureka.gateway.congfiguration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/products/**")
                        .uri("lb://PRODUCTS-SERVICE"))

                .route(r -> r.path("/cart/**")
                        .uri("lb://CART-SERVICE"))
                .build();
    }
}
