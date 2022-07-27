package com.kurdestan.bootcamp.file_attachment;

import com.kurdestan.bootcamp.common.exception.NotFoundException;
import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileAttachmentService implements IFileAttchmentService {

  private  final FileAttachmentRepository repository;
  private  final IEmployeeService employeeService;



    @Override
    public FileAttachment save(FileAttachment fileAttachment) {
     Long empId=  fileAttachment.getEmployee().getId();
     Employee employee=  employeeService.getById(empId);
     fileAttachment.setEmployee(employee);

        return repository.save(fileAttachment);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public FileAttachment getById(Long id) {
        Optional<FileAttachment> optionalFileAttachment=repository.findById(id);

        if (!optionalFileAttachment.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalFileAttachment.get();
    }

    @Override
    public List<FileAttachment> getAll() {
        return (List<FileAttachment>) repository.findAll();
    }

    @Override
    public FileAttachment getByEmployeeId(Long empId) {

      Employee emp=  employeeService.getById(empId);
        return repository.findByEmployee(emp);
    }


}
