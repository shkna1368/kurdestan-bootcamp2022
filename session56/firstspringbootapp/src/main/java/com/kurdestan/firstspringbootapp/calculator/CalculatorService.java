package com.kurdestan.firstspringbootapp.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public Long sum(Long num1, Long num2) {
        return num1+num2;
    }

    @Override
    public Long minus(Long num1, Long num2) {
        return num1-num2;
    }
}
