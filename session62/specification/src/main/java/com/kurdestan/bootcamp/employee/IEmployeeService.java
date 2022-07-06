package com.kurdestan.bootcamp.employee;

import com.kurdestan.bootcamp.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
     Employee save(Employee employee);
     Employee update(Employee employee);
     void delete(Long id);
     Employee getById(Long id);
    List<Employee> getAll();
    List<Employee> filterByMarriaed(Boolean isMarried);

Page<Employee> paging(Integer page,Integer size);
    List<Employee> search(List<SearchCriteria> searchCriteria);

}
