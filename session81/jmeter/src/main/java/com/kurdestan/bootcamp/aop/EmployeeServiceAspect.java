package com.kurdestan.bootcamp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class EmployeeServiceAspect {
    @Before(value = "execution(* com.kurdestan.bootcamp.employee.EmployeeService.*(..)) && args(id)")
    public void beforeAdvice(JoinPoint joinPoint, Long id) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Get Employee with  id - " + id);

    }

    @After(value = "execution(* com.kurdestan.bootcamp.employee.EmployeeService.*(..)) && args(id)")
    public void afterAdvice(JoinPoint joinPoint, Long id) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Get Employee with  id - " + id);
    }
}
