package com.kurdestanbootcamp.fileattachmentservice.file_attachment;


import com.kurdestanbootcamp.fileattachmentservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FileAttachmentDTO extends BaseDTO {



    @ApiModelProperty(required = true,hidden = false)
    private String personalImage;


    @ApiModelProperty(required = true,hidden = false)
    private String lastLicenseImage;


    @ApiModelProperty(required = true,hidden = false)
    private Long employeeId;



}
