package com.kurdestan.bootcamp.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(source = "birthDay",target ="birthDay",ignore = false,qualifiedByName = "employeeTimestampToDate")
    })
    Employee toEmployee(EmployeeDTO employeeDTO);


    @Mappings({
            @Mapping(source = "birthDay",target ="birthDay",ignore = false,qualifiedByName = "employeeDateToTimestamp")
    })
    EmployeeDTO toEmployeeDTO(Employee employee);

    List<Employee> toEmployeeList(List<EmployeeDTO> employeeDTOS);
    List<EmployeeDTO> toEmployeeDTOs(List<Employee> employeeList);


   @Named("employeeTimestampToDate")
    default Date toDate(Long timestamp){
       if (timestamp!=null)
            return new Date(timestamp);

       return null ;

   }

     @Named("employeeDateToTimestamp")
    default Long toTimestamp(Date date){
       if (date!=null)
            return date.getTime();

       return null ;

   }


}
