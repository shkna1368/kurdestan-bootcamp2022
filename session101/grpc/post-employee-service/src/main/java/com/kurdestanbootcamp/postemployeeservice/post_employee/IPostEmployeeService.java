package com.kurdestanbootcamp.postemployeeservice.post_employee;

import java.util.List;
import java.util.Map;

public interface IPostEmployeeService {

    PostEmployee save(PostEmployee family);
    void delete(Long id);
    Map<String ,Object> getById(Long id);
    List<PostEmployee> getAll();
    List<PostEmployee> getAllByEmployee(Long empId);
    List<PostEmployee> getAllByPost(Long postId);


}
