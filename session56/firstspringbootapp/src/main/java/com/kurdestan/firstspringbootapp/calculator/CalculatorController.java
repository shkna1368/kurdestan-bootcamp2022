package com.kurdestan.firstspringbootapp.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {


    ICalculatorService calculatorService;

    public CalculatorController(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

   @GetMapping("/sum/{n1}/{n2}")

    public ResponseEntity<Long> sum(@PathVariable Long n1,@PathVariable Long n2){

    var result=    calculatorService.sum(n1,n2);

    return ResponseEntity.ok(result);


   }

   @GetMapping("/minus/{n1}/{n2}")

    public ResponseEntity<Long> minus(@PathVariable Long n1,@PathVariable Long n2){

    var result=    calculatorService.minus(n1,n2);

    return ResponseEntity.ok(result);


   }



}
