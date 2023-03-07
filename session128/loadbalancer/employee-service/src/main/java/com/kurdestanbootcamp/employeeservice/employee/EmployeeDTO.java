package com.kurdestanbootcamp.employeeservice.employee;


import com.kurdestanbootcamp.employeeservice.common.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class EmployeeDTO extends BaseDTO {



    @Schema(hidden = false)

    private String name;


    @Schema(hidden = false)

    private String family;

    @Schema(hidden = false)

    private String nationalCode;

    @Schema(hidden = false)

    private Gender gender;


    @Schema(hidden = false)
    private Long birthDay;


    @Schema(hidden = false)

    private Boolean isMarried;

    @Schema(hidden = true)

    private Integer childCount;











}
