package com.kurdestanbootcamp.fileattachmentservice.file_attachment;

import com.kurdestanbootcamp.fileattachmentservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileAttachmentService implements IFileAttchmentService {

  private  final FileAttachmentRepository repository;



    @Override
    public FileAttachment save(FileAttachment fileAttachment) {


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
        return repository.findByEmployeeId(empId);
    }


}
