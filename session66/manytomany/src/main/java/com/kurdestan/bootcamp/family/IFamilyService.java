package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.common.SearchCriteria;
import com.kurdestan.bootcamp.employee.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IFamilyService {

    Family save(Family family);
    void delete(Long id);
    Family getById(Long id);
    List<Family> getAll();
    List<Family> getAllByEmployee(Long empId);


}
