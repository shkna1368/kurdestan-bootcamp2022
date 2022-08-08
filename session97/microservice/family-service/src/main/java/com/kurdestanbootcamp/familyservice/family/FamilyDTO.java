package com.kurdestanbootcamp.familyservice.family;


import com.kurdestanbootcamp.familyservice.common.BaseDTO;
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
    private Long employeeId;






}
