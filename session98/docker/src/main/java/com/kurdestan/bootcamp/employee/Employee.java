package com.kurdestan.bootcamp.employee;


import com.kurdestan.bootcamp.common.BaseEntity;
import com.kurdestan.bootcamp.family.Family;
import com.kurdestan.bootcamp.file_attachment.FileAttachment;
import com.kurdestan.bootcamp.post_employee.PostEmployee;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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


@OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL)
private List<Family> families;



    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL)
    private List<PostEmployee> postEmployeeList;

    @OneToOne(fetch = FetchType.LAZY,mappedBy ="employee",cascade = CascadeType.ALL)
    private FileAttachment fileAttachment;



}
