package com.kurdestan.bootcamp.family;

import com.kurdestan.bootcamp.common.BaseEntity;
import com.kurdestan.bootcamp.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_family",uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id","national_code"})})
@Data
public class Family extends BaseEntity {



    @NotNull
    @Column(name = "full_name")
    private String fullName;

     @NotNull
    @Column(name = "national_code")
    private String nationaCode;

     @ManyToOne()
     @JoinColumn(name = "employee_id")
     private Employee employee;

}
