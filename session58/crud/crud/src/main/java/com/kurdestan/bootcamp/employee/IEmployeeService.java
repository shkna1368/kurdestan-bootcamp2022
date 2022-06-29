package com.kurdestan.bootcamp.employee;

import java.util.List;

public interface IEmployeeService {
     Employee save(Employee employee);
     Employee update(Employee employee);
     void delete(Long id);
     Employee getById(Long id);
    List<Employee> getAll();
    List<Employee> filterByMarriaed(Boolean isMarried);



}
