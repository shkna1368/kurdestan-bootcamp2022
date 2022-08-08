package com.kurdestanbootcamp.postemployeeservice.post_employee;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostEmployeeMapper {

    PostEmployee toPostEmployee(PostEmployeeDTO postEmployeeDTO);
    PostEmployeeDTO toPostEmployeeDTO(PostEmployee postEmployee);

    List<PostEmployeeDTO> toPostEmployeeDTOs(List<PostEmployee> postEmployeeList);

}
