package com.learn.postapigateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("post-core-api", r -> r.path("/post/**")
                        .uri("http://localhost:8083/"))
                .build();
    }
}

