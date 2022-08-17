package com.kurdestanbootcamp.postemployeeservice.post_client;

import com.kurdestanbootcamp.postemployeeservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String title;






}
