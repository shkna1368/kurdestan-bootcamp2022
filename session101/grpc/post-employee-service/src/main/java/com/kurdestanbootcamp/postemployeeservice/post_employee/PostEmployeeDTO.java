package com.kurdestanbootcamp.postemployeeservice.post_employee;


import com.kurdestanbootcamp.postemployeeservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostEmployeeDTO extends BaseDTO {



    @ApiModelProperty(required = true,hidden = false)
    private Long postId;


    @ApiModelProperty(required = true,hidden = false)
    private Long employeeId;






}
