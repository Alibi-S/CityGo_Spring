package com.example.placeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlaceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaceApiApplication.class, args);
    }

}
