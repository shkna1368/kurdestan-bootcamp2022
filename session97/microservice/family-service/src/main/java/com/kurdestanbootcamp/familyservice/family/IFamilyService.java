package com.kurdestanbootcamp.familyservice.family;

import java.util.List;

public interface IFamilyService {

    Family save(Family family);
    void delete(Long id);
    Family getById(Long id);
    List<Family> getAll();
    List<Family> getAllByEmployee(Long empId);


}
