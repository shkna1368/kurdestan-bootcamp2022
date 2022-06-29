package com.kurdestan.bootcamp.employee;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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
