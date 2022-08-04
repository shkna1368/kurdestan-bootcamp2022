package com.kurdestan.bootcamp.employee_family_master_details;

import com.kurdestan.bootcamp.employee.EmployeeDTO;
import com.kurdestan.bootcamp.family.FamilyDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeFamilyMasterDetailDTO {

    @ApiModelProperty(required = true,hidden = false)

    private EmployeeDTO employeeDTO;
    @ApiModelProperty(required = true,hidden = false)
    private List<FamilyDTO> familyDTOS;
}
