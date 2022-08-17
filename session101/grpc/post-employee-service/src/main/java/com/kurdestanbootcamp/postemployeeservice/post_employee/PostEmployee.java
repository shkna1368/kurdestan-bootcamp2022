package com.kurdestanbootcamp.postemployeeservice.post_employee;


import com.kurdestanbootcamp.postemployeeservice.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "tbl_post_employee",uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id","post_id"})})
@Data
@Audited
public class PostEmployee extends BaseEntity {


    @Column(name = "post_id")
    private Long postId;

     @Column(name = "employee_id")
    private Long employeeId;


}
