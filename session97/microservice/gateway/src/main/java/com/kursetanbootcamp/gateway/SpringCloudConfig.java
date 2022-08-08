package com.kursetanbootcamp.gateway;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/employeeservice/**")
                        .uri("lb://employee-service")
                )

                .route(r -> r.path("/familyservice/**")
                        .uri("lb://family-service")
                )

                 .route(r -> r.path("/postservice/**")
                        .uri("lb://post-service")
                )

                   .route(r -> r.path("/postemployeeservice/**")
                        .uri("lb://post-employee-service")
                )
                   .route(r -> r.path("/fileattachmentservice/**")
                        .uri("lb://file-attachment-service")
                )


                .build();
    }

}