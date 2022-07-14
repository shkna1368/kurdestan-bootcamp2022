package com.kurdestan.bootcamp.file_attachment;


import com.kurdestan.bootcamp.employee.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FileAttachmentDTO {

 @ApiModelProperty(required = false,hidden = true)
  private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String personalImage;


    @ApiModelProperty(required = true,hidden = false)
    private String lastLicenseImage;


    @ApiModelProperty(required = true,hidden = false)
    private EmployeeDTO employee;



}
