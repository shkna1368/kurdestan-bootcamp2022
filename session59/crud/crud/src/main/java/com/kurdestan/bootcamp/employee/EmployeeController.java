package com.kurdestan.bootcamp.employee;

import com.kurdestan.bootcamp.common.PagingData;
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


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody Employee employee){

        service.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody Employee employee){

        service.save(employee);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id ){

    Employee employee=    service.getById(id);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<Employee>> getAll(){

    List<Employee> employeeList=    service.getAll();
        return ResponseEntity.ok(employeeList);
    }
     @GetMapping("/v1/filter-married/{isMarried}")
    public ResponseEntity<List<Employee>> filterByIsMarriesd(@PathVariable Boolean isMarried){

    List<Employee> employeeList=    service.filterByMarriaed(isMarried);
        return ResponseEntity.ok(employeeList);
    }
    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<Employee>> filterByIsMarriesd(@PathVariable Integer page,Integer size){

        Page<Employee> employeePage=    service.paging(page,size);

    int totalPage=  employeePage.getTotalPages();
   List<Employee> data= employeePage.getContent();
        PagingData<Employee> pagingData=new PagingData<>(totalPage,page,data)  ;


        return ResponseEntity.ok(pagingData);
    }
}
