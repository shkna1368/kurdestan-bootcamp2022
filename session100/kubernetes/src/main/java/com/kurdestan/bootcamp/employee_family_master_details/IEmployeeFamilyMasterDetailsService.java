package com.kurdestan.bootcamp.employee_family_master_details;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.family.Family;

import java.util.List;

public interface IEmployeeFamilyMasterDetailsService {


    void save(Employee employee, List<Family> familyList) ;
}
