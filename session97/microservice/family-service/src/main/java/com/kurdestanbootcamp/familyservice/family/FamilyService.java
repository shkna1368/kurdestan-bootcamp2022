package com.kurdestanbootcamp.familyservice.family;


import com.kurdestanbootcamp.familyservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FamilyService implements IFamilyService{
    private  final FamilyRepository repository;

    @Override
    public Family save(Family family) {


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
        List<Family> families=repository.findAllByEmployeeId(empId);
        return families;
    }


}
