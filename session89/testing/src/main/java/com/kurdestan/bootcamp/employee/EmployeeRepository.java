package com.kurdestan.bootcamp.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

List<Employee> findAllByIsMarried(Boolean isMarried);
List<Employee> findAllByChildCountGreaterThan(Integer count);
List<Employee> findAllByBirthDayBetween(Date from,Date to);
List<Employee> findAllByBirthDayBefore(Date from);

Page<Employee> findAll(Pageable pageable);
Page<Employee> findAll(Specification<Employee> specification, Pageable pageable);
List<Employee> findAll(Specification<Employee> specification);


}
