package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.common.exception.NotFoundException;
import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import com.kurdestan.bootcamp.family.Family;
import com.kurdestan.bootcamp.post.IPostService;
import com.kurdestan.bootcamp.post.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostEmployeeService implements IPostEmployeeService {


    private  final PostEmployeeRepository repository;
    private  final IEmployeeService employeeService;
    private  final IPostService postService;





    @Override
    public PostEmployee save(PostEmployee postEmployee) {
       Long empId=postEmployee.getEmployee().getId();
       Long postId=postEmployee.getPost().getId();

       Employee employee=employeeService.getById(empId);
       Post post=postService.getById(postId);

        postEmployee.setEmployee(employee);
        postEmployee.setPost(post);

        return repository.save(postEmployee);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public PostEmployee getById(Long id) {
        Optional<PostEmployee> optionalPostEmployee=repository.findById(id);

        if (!optionalPostEmployee.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalPostEmployee.get();
    }

    @Override
    public List<PostEmployee> getAll() {
        return (List<PostEmployee>) repository.findAll();
    }

    @Override
    public List<PostEmployee> getAllByEmployee(Long empId) {
        Employee employee=employeeService.getById(empId);

        List<PostEmployee> postEmployees=repository.findAllByEmployee(employee);


        return postEmployees;
    }

    @Override
    public List<PostEmployee> getAllByPost(Long postId) {
        Post post=postService.getById(postId);

        List<PostEmployee> postEmployeeList=repository.findAllByPost(post);


        return postEmployeeList;
    }


}
