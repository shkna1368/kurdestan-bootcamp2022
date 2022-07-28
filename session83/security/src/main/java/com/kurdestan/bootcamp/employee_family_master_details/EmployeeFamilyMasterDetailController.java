package com.kurdestan.bootcamp.employee_family_master_details;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.EmployeeMapper;
import com.kurdestan.bootcamp.family.Family;
import com.kurdestan.bootcamp.family.FamilyMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/employee-family-master-detail")
public class EmployeeFamilyMasterDetailController {


    private final EmployeeMapper employeeMapper;
    private final FamilyMapper familyMapper;
    private final IEmployeeFamilyMasterDetailsService employeeFamilyMasterDetailsService ;


    @PostMapping
    public ResponseEntity save(@RequestBody  EmployeeFamilyMasterDetailDTO employeeFamilyMasterDetailDTO){

          Employee employee=employeeMapper.toEmployee(employeeFamilyMasterDetailDTO.getEmployeeDTO());

        List<Family> familyList=familyMapper.toFamilies(employeeFamilyMasterDetailDTO.getFamilyDTOS());


        employeeFamilyMasterDetailsService.save(employee,familyList);


        return ResponseEntity.ok().build();


    }





}
