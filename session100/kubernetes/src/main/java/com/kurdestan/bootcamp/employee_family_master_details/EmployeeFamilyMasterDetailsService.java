package com.kurdestan.bootcamp.employee_family_master_details;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import com.kurdestan.bootcamp.family.Family;
import com.kurdestan.bootcamp.family.IFamilyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
public class EmployeeFamilyMasterDetailsService implements IEmployeeFamilyMasterDetailsService{

    private final IEmployeeService employeeService;
    private final IFamilyService familyService;

    @Transactional()
    @Override
    public void save(Employee employee, List<Family> families) {

      Employee savedEmployee=  employeeService.save(employee);
      //  int x=1/0;
        families.forEach(family -> {

            family.setEmployee(savedEmployee);
            familyService.save(family);
        });

    }
}
