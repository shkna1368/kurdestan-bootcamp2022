package com.kurdestan.bootcamp.config;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PemController {


    @GetMapping("/hi")
    @Timed(value = "PemController.sayHi", description = "Time taken to sayHi")
    public String sayHi(){

        return "hi premetus";
    }
}
