package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.common.BaseEntity;
import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.post.Post;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "tbl_post_employee",uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id","post_id"})})
@Data
@Audited
public class PostEmployee extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

     @ManyToOne
     @JoinColumn(name = "employee_id")
    private Employee employee;


}
