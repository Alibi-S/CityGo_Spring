package com.example.guildsapi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GuildsApi2Application {

    public static void main(String[] args) {
        SpringApplication.run(GuildsApi2Application.class, args);
    }

}
