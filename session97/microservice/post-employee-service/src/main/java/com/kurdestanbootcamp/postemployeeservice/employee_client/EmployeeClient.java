package com.kurdestanbootcamp.postemployeeservice.employee_client;


import com.kurdestanbootcamp.postemployeeservice.common.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee", url = "http://localhost:8080/employeeservice/employee", configuration = FeignConfig.class)

public interface EmployeeClient {

    @GetMapping(value = "/v1/{employeeId}")
    EmployeeDTO getEmployee(@PathVariable(value = "employeeId") Long empId);
}
