package com.kurdestanbootcamp.postemployeeservice.post_employee;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/post-employee/")
@AllArgsConstructor
public class PostEmployeeController {

    private final IPostEmployeeService service;
    private PostEmployeeMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PostEmployeeDTO postEmployeeDTO){
    PostEmployee postEmployee=mapper.toPostEmployee(postEmployeeDTO);
        service.save(postEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<Map<String,Object>> getById(@PathVariable Long id ){


        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/v1")
    public ResponseEntity<List<PostEmployeeDTO>> getAll(){

    List<PostEmployee> postEmployees=    service.getAll();


    List<PostEmployeeDTO> postEmployeeDTOS=    mapper.toPostEmployeeDTOs(postEmployees);


        return ResponseEntity.ok(postEmployeeDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/get-by-employee/{empId}")
    public ResponseEntity<List<PostEmployeeDTO>> getByEmployeeId(@PathVariable Long empId ){

        List<PostEmployee> postEmployees=    service.getAllByEmployee(empId);
        List<PostEmployeeDTO> postEmployeeDTOS=mapper.toPostEmployeeDTOs(postEmployees);
        return ResponseEntity.ok(postEmployeeDTOS);
    }

    @GetMapping("/v1/get-by-post/{postId}")
    public ResponseEntity<List<PostEmployeeDTO>> getByPostId(@PathVariable Long postId ){

        List<PostEmployee> postEmployees=    service.getAllByPost(postId);
        List<PostEmployeeDTO> postEmployeeDTOS=mapper.toPostEmployeeDTOs(postEmployees);
        return ResponseEntity.ok(postEmployeeDTOS);
    }


}
