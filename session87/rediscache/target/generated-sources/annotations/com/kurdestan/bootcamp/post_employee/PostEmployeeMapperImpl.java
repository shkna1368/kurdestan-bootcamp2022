package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.employee.EmployeeMapper;
import com.kurdestan.bootcamp.post.PostMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T17:20:02+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PostEmployeeMapperImpl implements PostEmployeeMapper {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PostMapper postMapper;

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
        postEmployee.setPost( postMapper.toPost( postEmployeeDTO.getPost() ) );
        postEmployee.setEmployee( employeeMapper.toEmployee( postEmployeeDTO.getEmployee() ) );

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
        postEmployeeDTO.setPost( postMapper.toPostDTO( postEmployee.getPost() ) );
        postEmployeeDTO.setEmployee( employeeMapper.toEmployeeDTO( postEmployee.getEmployee() ) );

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
