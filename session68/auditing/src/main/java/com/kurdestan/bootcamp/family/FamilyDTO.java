package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.common.BaseDTO;
import com.kurdestan.bootcamp.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FamilyDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String fullName;


    @ApiModelProperty(required = true,hidden = false)
    private String nationaCode;


     @ApiModelProperty(required = true,hidden = false)
    private EmployeeDTO employee;






}
