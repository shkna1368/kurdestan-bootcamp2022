package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.employee.EmployeeDTO;
import com.kurdestan.bootcamp.post.PostDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostEmployeeDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private PostDTO post;


    @ApiModelProperty(required = true,hidden = false)
    private EmployeeDTO employee;






}
