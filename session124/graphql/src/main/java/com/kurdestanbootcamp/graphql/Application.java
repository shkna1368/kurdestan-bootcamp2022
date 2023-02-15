package com.kurdestanbootcamp.graphql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.FileInputStream;


@SpringBootApplication
@EnableFeignClients
public class Application  {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
