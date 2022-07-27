package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.family.Family;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {


}
