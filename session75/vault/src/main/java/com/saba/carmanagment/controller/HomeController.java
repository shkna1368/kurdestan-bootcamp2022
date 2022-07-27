package com.saba.carmanagment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
class HomeController{

    @Value("${check.flag}")
    private Boolean checkFlag;

    @GetMapping(value = "/greet")
    public String greet() {

        return checkFlag ? "Good Morning" : "Good Bye";
    }
}