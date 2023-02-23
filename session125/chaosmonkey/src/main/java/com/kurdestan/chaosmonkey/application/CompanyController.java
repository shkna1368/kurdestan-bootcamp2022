package com.kurdestan.chaosmonkey.application;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/company")
public class CompanyController {

final
CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping(value = "/all")
    public List<Company> getAll() {

     // return   companyService.getAll();
        List<Company> companies = null;
        try {
            companies = companyService.getAll();
        } catch (Exception e) {
            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
            System.out.println("Caught an Exception....");
            companies = new ArrayList<>();
        }
        return companies;
    }


}
