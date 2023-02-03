package com.kurdestan.resilienc4j.common;

import com.kurdestan.resilienc4j.common.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PostDTO extends BaseDTO {

    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = false)
    private String title;






}
