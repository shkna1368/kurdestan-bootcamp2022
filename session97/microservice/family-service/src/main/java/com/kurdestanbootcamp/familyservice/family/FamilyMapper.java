package com.kurdestanbootcamp.familyservice.family;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FamilyMapper {

    Family toFamily(FamilyDTO familyDTO);
    FamilyDTO toFamilyDTO(Family family);

    List<FamilyDTO> toFamilytDTOs(List<Family> families);

}
