package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.common.PagingData;
import com.kurdestan.bootcamp.common.SearchCriteria;
import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.EmployeeDTO;
import com.kurdestan.bootcamp.employee.EmployeeMapper;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/family/")
@AllArgsConstructor
public class FamilyController {

    private final IFamilyService service;
    private FamilyMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FamilyDTO familyDTO){
    Family family=mapper.toFamily(familyDTO);
        service.save(family);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FamilyDTO> getById(@PathVariable Long id ){

    Family family=    service.getById(id);
    FamilyDTO familyDTO=mapper.toFamilyDTO(family);
        return ResponseEntity.ok(familyDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<FamilyDTO>> getAll(){

    List<Family> families=    service.getAll();


    List<FamilyDTO> familyDTOs=    mapper.toFamilytDTOs(families);


        return ResponseEntity.ok(familyDTOs);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/get-by-employee/{empId}")
    public ResponseEntity<List<FamilyDTO>> getByEmployeeId(@PathVariable Long empId ){

        List<Family> families=    service.getAllByEmployee(empId);
        List<FamilyDTO> familyDTOs=mapper.toFamilytDTOs(families);
        return ResponseEntity.ok(familyDTOs);
    }
}
