package com.kurdestan.bootcamp.employee;

import com.kurdestan.bootcamp.common.PagingData;
import com.kurdestan.bootcamp.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee/")
@AllArgsConstructor
public class EmployeeController {

    private final IEmployeeService service;
    private EmployeeMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody EmployeeDTO employeeDTO){
Employee employee=mapper.toEmployee(employeeDTO);
        service.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=mapper.toEmployee(employeeDTO);

        service.update(employee);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id ){

    Employee employee=    service.getById(id);
    EmployeeDTO employeeDTO=mapper.toEmployeeDTO(employee);
        return ResponseEntity.ok(employeeDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<EmployeeDTO>> getAll(){

    List<Employee> employeeList=    service.getAll();


    List<EmployeeDTO> employeeDTOS=    mapper.toEmployeeDTOs(employeeList);


        return ResponseEntity.ok(employeeDTOS);
    }
     @GetMapping("/v1/filter-married/{isMarried}")
    public ResponseEntity<List<EmployeeDTO>> filterByIsMarriesd(@PathVariable Boolean isMarried){

    List<Employee> employeeList=    service.filterByMarriaed(isMarried);
         List<EmployeeDTO> employeeDTOS=    mapper.toEmployeeDTOs(employeeList);

         return ResponseEntity.ok(employeeDTOS);
    }
    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<EmployeeDTO>> filterByIsMarriesd(@PathVariable Integer page,Integer size){

        Page<Employee> employeePage=    service.paging(page,size);

    int totalPage=  employeePage.getTotalPages();
   List<Employee> data= employeePage.getContent();
        List<EmployeeDTO> employeeDTOS=    mapper.toEmployeeDTOs(data);



        PagingData<EmployeeDTO> pagingData=new PagingData<>(totalPage,page,employeeDTOS)  ;


        return ResponseEntity.ok(pagingData);
    }



    @PostMapping("/v1/search")
    public ResponseEntity<List<EmployeeDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
      List<Employee> employeeList=  service.search(searchCriteria);
List<EmployeeDTO> employeeDTOS=mapper.toEmployeeDTOs(employeeList);

        return ResponseEntity.ok(employeeDTOS);
    }

}
