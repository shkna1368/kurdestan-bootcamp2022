package com.kurdestan.bootcamp.file_attachment;

import com.kurdestan.bootcamp.employee.EmployeeMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T23:04:06+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class FileAttachmentMapperImpl implements FileAttachmentMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public FileAttachment toFileAttachment(FileAttachmentDTO fileAttachmentDTO) {
        if ( fileAttachmentDTO == null ) {
            return null;
        }

        FileAttachment fileAttachment = new FileAttachment();

        fileAttachment.setId( fileAttachmentDTO.getId() );
        fileAttachment.setVersion( fileAttachmentDTO.getVersion() );
        fileAttachment.setCreatedDate( fileAttachmentDTO.getCreatedDate() );
        fileAttachment.setCreatedBy( fileAttachmentDTO.getCreatedBy() );
        fileAttachment.setLastModifiedDate( fileAttachmentDTO.getLastModifiedDate() );
        fileAttachment.setLastModifiedBy( fileAttachmentDTO.getLastModifiedBy() );
        fileAttachment.setPersonalImage( fileAttachmentDTO.getPersonalImage() );
        fileAttachment.setLastLicenseImage( fileAttachmentDTO.getLastLicenseImage() );
        fileAttachment.setEmployee( employeeMapper.toEmployee( fileAttachmentDTO.getEmployee() ) );

        return fileAttachment;
    }

    @Override
    public FileAttachmentDTO toFileAttachmentDTO(FileAttachment fileAttachment) {
        if ( fileAttachment == null ) {
            return null;
        }

        FileAttachmentDTO fileAttachmentDTO = new FileAttachmentDTO();

        fileAttachmentDTO.setId( fileAttachment.getId() );
        fileAttachmentDTO.setVersion( fileAttachment.getVersion() );
        fileAttachmentDTO.setCreatedDate( fileAttachment.getCreatedDate() );
        fileAttachmentDTO.setCreatedBy( fileAttachment.getCreatedBy() );
        fileAttachmentDTO.setLastModifiedDate( fileAttachment.getLastModifiedDate() );
        fileAttachmentDTO.setLastModifiedBy( fileAttachment.getLastModifiedBy() );
        fileAttachmentDTO.setPersonalImage( fileAttachment.getPersonalImage() );
        fileAttachmentDTO.setLastLicenseImage( fileAttachment.getLastLicenseImage() );
        fileAttachmentDTO.setEmployee( employeeMapper.toEmployeeDTO( fileAttachment.getEmployee() ) );

        return fileAttachmentDTO;
    }

    @Override
    public List<FileAttachment> toFileAttachmentList(List<FileAttachmentDTO> fileAttachmentDTOs) {
        if ( fileAttachmentDTOs == null ) {
            return null;
        }

        List<FileAttachment> list = new ArrayList<FileAttachment>( fileAttachmentDTOs.size() );
        for ( FileAttachmentDTO fileAttachmentDTO : fileAttachmentDTOs ) {
            list.add( toFileAttachment( fileAttachmentDTO ) );
        }

        return list;
    }

    @Override
    public List<FileAttachmentDTO> toFileAttachmentDTOs(List<FileAttachment> fileAttachments) {
        if ( fileAttachments == null ) {
            return null;
        }

        List<FileAttachmentDTO> list = new ArrayList<FileAttachmentDTO>( fileAttachments.size() );
        for ( FileAttachment fileAttachment : fileAttachments ) {
            list.add( toFileAttachmentDTO( fileAttachment ) );
        }

        return list;
    }
}
