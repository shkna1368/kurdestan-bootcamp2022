package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.employee.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FamilyRepository extends ListCrudRepository<Family,Long> {
List<Family> findAllByEmployee(Employee employee);


}
