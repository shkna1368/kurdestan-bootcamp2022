package com.kurdestanbootcamp.employeeservice.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


@Data
public class BaseDTO {
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private Integer version;

    @Schema  (hidden = true)
    private Date createdDate;

    @Schema(hidden = true)
    private String createdBy;

    @Schema(required = false,hidden = true)
    private Date lastModifiedDate;

    @Schema(required = false,hidden = true)
    private String lastModifiedBy;






}
