package com.kurdestan.bootcamp.employee;


import com.kurdestan.bootcamp.common.SearchCriteria;
import com.kurdestan.bootcamp.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService implements IEmployeeService{

  private  final EmployeeRepository repository;


    @Override
    public Employee save(Employee employee) {
       var emp= repository.save(employee);

       log.info("successfully save employee with id"+emp.getId());
        return emp;
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
       // lastSavedEmployee.setNationalCode(employee.getNationalCode());

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

            throw new NotFoundException("Not Found");
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

    @Override
    public Page<Employee> paging(Integer page, Integer size) {


        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Employee> search(List<SearchCriteria> searchCriteria) {
      EmployeeSpecification employeeSpecification=new EmployeeSpecification();

      searchCriteria.forEach(criteria -> employeeSpecification.add(criteria));

      return repository.findAll(employeeSpecification);

    }
}
