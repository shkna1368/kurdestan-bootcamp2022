package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.common.SearchCriteria;
import com.kurdestan.bootcamp.common.exception.NotFoundException;
import com.kurdestan.bootcamp.employee.Employee;

import com.kurdestan.bootcamp.employee.IEmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FamilyService implements IFamilyService{


    private  final FamilyRepository repository;
    private  final IEmployeeService employeeService;





    @Override
    public Family save(Family family) {
       Long empId=family.getEmployee().getId();

       Employee employee=employeeService.getById(empId);

        family.setEmployee(employee);

        return repository.save(family);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public Family getById(Long id) {
        Optional<Family> optionalFamily=repository.findById(id);

        if (!optionalFamily.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalFamily.get();
    }

    @Override
    public List<Family> getAll() {
        return (List<Family>) repository.findAll();
    }

    @Override
    public List<Family> getAllByEmployee(Long empId) {
        Employee employee=employeeService.getById(empId);

        List<Family> families=repository.findAllByEmployee(employee);


        return families;
    }


}
