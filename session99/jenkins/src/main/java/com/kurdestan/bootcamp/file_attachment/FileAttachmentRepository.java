package com.kurdestan.bootcamp.file_attachment;

import com.kurdestan.bootcamp.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAttachmentRepository extends PagingAndSortingRepository<FileAttachment,Long> {

FileAttachment findByEmployee(Employee employee);
}
