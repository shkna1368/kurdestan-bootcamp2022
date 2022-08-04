package com.kurdestan.bootcamp.file_attachment;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.family.Family;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAttachmentRepository extends ListCrudRepository<FileAttachment,Long>,PagingAndSortingRepository<FileAttachment,Long> {

FileAttachment findByEmployee(Employee employee);
}
