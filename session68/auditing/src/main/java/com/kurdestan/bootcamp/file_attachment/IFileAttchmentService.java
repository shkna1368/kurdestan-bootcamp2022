package com.kurdestan.bootcamp.file_attachment;

import java.util.List;

public interface IFileAttchmentService {
    FileAttachment save(FileAttachment fileAttachment);
    void delete(Long id);
    FileAttachment getById(Long id);
    List<FileAttachment> getAll();
    FileAttachment getByEmployeeId(Long empId);


}
