package com.kurdestanbootcamp.employeeservice.employee;


import com.kurdestanbootcamp.employeeservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EmployeeDTO extends BaseDTO {



    @ApiModelProperty(required = true,hidden = false)

    private String name;


    @ApiModelProperty(required = true,hidden = false)

    private String family;

    @ApiModelProperty(required = true,hidden = false)

    private String nationalCode;

    @ApiModelProperty(required = true,hidden = false)

    private Gender gender;


    @ApiModelProperty(required = true,hidden = false)
    private Long birthDay;


    @ApiModelProperty(required = true,hidden = false)

    private Boolean isMarried;

    @ApiModelProperty(required = false,hidden = true)

    private Integer childCount;











}
