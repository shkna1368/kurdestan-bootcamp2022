package com.kurdestanbootcamp.postemployeeservice;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableAdminServer

public class Application implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }




    @Override
    public void run(String... args) throws Exception {


    }
}
