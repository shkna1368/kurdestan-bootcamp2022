package com.kurdestanbootcamp.postemployeeservice.post_employee;


import com.kurdestanbootcamp.postemployeeservice.common.exception.NotFoundException;
import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeClient;
import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeDTO;
import com.kurdestanbootcamp.postemployeeservice.post_client.PostClient;
import com.kurdestanbootcamp.postemployeeservice.post_client.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostEmployeeService implements IPostEmployeeService {
    private  final PostEmployeeRepository repository;
    private  final PostClient postClient;
    private  final EmployeeClient employeeClient;


    @Override
    public PostEmployee save(PostEmployee postEmployee) {

        return repository.save(postEmployee);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public Map<String ,Object> getById(Long id) {
        Optional<PostEmployee> optionalPostEmployee=repository.findById(id);

        if (!optionalPostEmployee.isPresent()){

            throw new NotFoundException("Not Found");
        }

       PostEmployee postEmployee= optionalPostEmployee.get();

    PostDTO postDTO= postClient.getPost(postEmployee.getPostId())  ;
    EmployeeDTO employeeDTO= employeeClient.getEmployee(postEmployee.getEmployeeId())  ;

        Map<String,Object> data=new HashMap<>();
        data.put("postEmployeeId",postEmployee.getId());
        data.put("post",postDTO);
        data.put("employee",employeeDTO);
        return data;


    }

    @Override
    public List<PostEmployee> getAll() {
        return (List<PostEmployee>) repository.findAll();
    }

    @Override
    public List<PostEmployee> getAllByEmployee(Long empId) {


        List<PostEmployee> postEmployees=repository.findAllByEmployeeId(empId);


        return postEmployees;
    }

    @Override
    public List<PostEmployee> getAllByPost(Long postId) {


        List<PostEmployee> postEmployeeList=repository.findAllByPostId(postId);


        return postEmployeeList;
    }


}
