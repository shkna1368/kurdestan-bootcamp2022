package com.kurdestanbootcamp.employeeservice.employee;


import com.kurdestanbootcamp.employeeservice.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_employee")
@Data
@Audited
public class Employee extends BaseEntity {



    @NotNull
    @Column(name = "name")
    private String name;


    @NotNull
    @Column(name = "family")
    private String family;



    @NotNull
    @Column(name = "national_code",unique = true)
    private String nationalCode;


  @NotNull
  @Column(name = "gender")
  @Enumerated(value = EnumType.STRING)
    private Gender gender;

   @NotNull
  @Column(name = "birth_day")
   @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;


   @NotNull
  @Column(name = "married")
   private Boolean isMarried;

   @Column(name = "child_count")
   private Integer childCount;





}
