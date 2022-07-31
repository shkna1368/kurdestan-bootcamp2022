package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.family.Family;

import java.util.List;

public interface IPostEmployeeService {

    PostEmployee save(PostEmployee family);
    void delete(Long id);
    PostEmployee getById(Long id);
    List<PostEmployee> getAll();
    List<PostEmployee> getAllByEmployee(Long empId);
    List<PostEmployee> getAllByPost(Long postId);


}
