package com.kurdestan.bootcamp.employee;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T00:15:57+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setBirthDay( toDate( employeeDTO.getBirthDay() ) );
        employee.setId( employeeDTO.getId() );
        employee.setVersion( employeeDTO.getVersion() );
        employee.setCreatedDate( employeeDTO.getCreatedDate() );
        employee.setCreatedBy( employeeDTO.getCreatedBy() );
        employee.setLastModifiedDate( employeeDTO.getLastModifiedDate() );
        employee.setLastModifiedBy( employeeDTO.getLastModifiedBy() );
        employee.setName( employeeDTO.getName() );
        employee.setFamily( employeeDTO.getFamily() );
        employee.setNationalCode( employeeDTO.getNationalCode() );
        employee.setGender( employeeDTO.getGender() );
        employee.setIsMarried( employeeDTO.getIsMarried() );
        employee.setChildCount( employeeDTO.getChildCount() );

        return employee;
    }

    @Override
    public EmployeeDTO toEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setBirthDay( toTimestamp( employee.getBirthDay() ) );
        employeeDTO.setId( employee.getId() );
        employeeDTO.setVersion( employee.getVersion() );
        employeeDTO.setCreatedDate( employee.getCreatedDate() );
        employeeDTO.setCreatedBy( employee.getCreatedBy() );
        employeeDTO.setLastModifiedDate( employee.getLastModifiedDate() );
        employeeDTO.setLastModifiedBy( employee.getLastModifiedBy() );
        employeeDTO.setName( employee.getName() );
        employeeDTO.setFamily( employee.getFamily() );
        employeeDTO.setNationalCode( employee.getNationalCode() );
        employeeDTO.setGender( employee.getGender() );
        employeeDTO.setIsMarried( employee.getIsMarried() );
        employeeDTO.setChildCount( employee.getChildCount() );

        return employeeDTO;
    }

    @Override
    public List<Employee> toEmployeeList(List<EmployeeDTO> employeeDTOS) {
        if ( employeeDTOS == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeDTOS.size() );
        for ( EmployeeDTO employeeDTO : employeeDTOS ) {
            list.add( toEmployee( employeeDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> toEmployeeDTOs(List<Employee> employeeList) {
        if ( employeeList == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employeeList.size() );
        for ( Employee employee : employeeList ) {
            list.add( toEmployeeDTO( employee ) );
        }

        return list;
    }
}
