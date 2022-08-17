package com.kurdestanbootcamp.postemployeeservice.post_employee;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T20:23:22+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PostEmployeeMapperImpl implements PostEmployeeMapper {

    @Override
    public PostEmployee toPostEmployee(PostEmployeeDTO postEmployeeDTO) {
        if ( postEmployeeDTO == null ) {
            return null;
        }

        PostEmployee postEmployee = new PostEmployee();

        postEmployee.setId( postEmployeeDTO.getId() );
        postEmployee.setVersion( postEmployeeDTO.getVersion() );
        postEmployee.setCreatedDate( postEmployeeDTO.getCreatedDate() );
        postEmployee.setCreatedBy( postEmployeeDTO.getCreatedBy() );
        postEmployee.setLastModifiedDate( postEmployeeDTO.getLastModifiedDate() );
        postEmployee.setLastModifiedBy( postEmployeeDTO.getLastModifiedBy() );
        postEmployee.setPostId( postEmployeeDTO.getPostId() );
        postEmployee.setEmployeeId( postEmployeeDTO.getEmployeeId() );

        return postEmployee;
    }

    @Override
    public PostEmployeeDTO toPostEmployeeDTO(PostEmployee postEmployee) {
        if ( postEmployee == null ) {
            return null;
        }

        PostEmployeeDTO postEmployeeDTO = new PostEmployeeDTO();

        postEmployeeDTO.setId( postEmployee.getId() );
        postEmployeeDTO.setVersion( postEmployee.getVersion() );
        postEmployeeDTO.setCreatedDate( postEmployee.getCreatedDate() );
        postEmployeeDTO.setCreatedBy( postEmployee.getCreatedBy() );
        postEmployeeDTO.setLastModifiedDate( postEmployee.getLastModifiedDate() );
        postEmployeeDTO.setLastModifiedBy( postEmployee.getLastModifiedBy() );
        postEmployeeDTO.setPostId( postEmployee.getPostId() );
        postEmployeeDTO.setEmployeeId( postEmployee.getEmployeeId() );

        return postEmployeeDTO;
    }

    @Override
    public List<PostEmployeeDTO> toPostEmployeeDTOs(List<PostEmployee> postEmployeeList) {
        if ( postEmployeeList == null ) {
            return null;
        }

        List<PostEmployeeDTO> list = new ArrayList<PostEmployeeDTO>( postEmployeeList.size() );
        for ( PostEmployee postEmployee : postEmployeeList ) {
            list.add( toPostEmployeeDTO( postEmployee ) );
        }

        return list;
    }
}
