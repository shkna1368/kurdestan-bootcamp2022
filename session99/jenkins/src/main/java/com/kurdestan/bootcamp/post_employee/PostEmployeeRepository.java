package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostEmployeeRepository extends PagingAndSortingRepository<PostEmployee,Long> {

List<PostEmployee> findAllByPost(Post post);
List<PostEmployee> findAllByEmployee(Employee employee);
}
