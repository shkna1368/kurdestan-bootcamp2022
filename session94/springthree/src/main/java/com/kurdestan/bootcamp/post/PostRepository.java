package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.family.Family;
import com.kurdestan.bootcamp.file_attachment.FileAttachment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends ListCrudRepository<Post,Long>,PagingAndSortingRepository<Post,Long> {


}
