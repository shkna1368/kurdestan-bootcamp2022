package com.kurdestan.bootcamp.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService{

  private  final EmployeeRepository repository;



    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {

        Employee lastSavedEmployee=getById(employee.getId());

        lastSavedEmployee.setName(employee.getName());
        lastSavedEmployee.setFamily(employee.getFamily());
        lastSavedEmployee.setGender(employee.getGender());
        lastSavedEmployee.setIsMarried(employee.getIsMarried());
        lastSavedEmployee.setChildCount(employee.getChildCount());
        lastSavedEmployee.setBirthDay(employee.getBirthDay());
        lastSavedEmployee.setNationalCode(employee.getNationalCode());

        return repository.save(lastSavedEmployee);
    }

    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optionalEmployee=repository.findById(id);

        if (!optionalEmployee.isPresent()){

            throw new RuntimeException("Not Found");
        }


        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public List<Employee> filterByMarriaed(Boolean isMarried) {
        return repository.findAllByIsMarried(isMarried);
    }
}
