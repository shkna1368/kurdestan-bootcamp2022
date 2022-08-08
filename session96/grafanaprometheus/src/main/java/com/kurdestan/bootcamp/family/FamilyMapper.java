package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.employee.EmployeeMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EmployeeMapper.class})
public interface FamilyMapper {

    Family toFamily(FamilyDTO familyDTO);
    FamilyDTO toFamilyDTO(Family family);

    List<FamilyDTO> toFamilytDTOs(List<Family> families);
    List<Family> toFamilies(List<FamilyDTO> familyDTOS);

}
