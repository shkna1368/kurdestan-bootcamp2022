package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.common.BaseDTO;
import com.kurdestan.bootcamp.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String title;






}
