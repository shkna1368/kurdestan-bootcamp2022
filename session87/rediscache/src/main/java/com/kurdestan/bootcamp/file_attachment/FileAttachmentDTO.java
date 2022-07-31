package com.kurdestan.bootcamp.file_attachment;


import com.kurdestan.bootcamp.common.BaseDTO;
import com.kurdestan.bootcamp.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FileAttachmentDTO extends BaseDTO {



    @ApiModelProperty(required = true,hidden = false)
    private String personalImage;


    @ApiModelProperty(required = true,hidden = false)
    private String lastLicenseImage;


    @ApiModelProperty(required = true,hidden = false)
    private EmployeeDTO employee;



}
