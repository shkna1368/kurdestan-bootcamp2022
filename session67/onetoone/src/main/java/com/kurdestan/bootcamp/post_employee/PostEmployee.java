package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.post.Post;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_post_employee",uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id","post_id"})})
@Data
public class PostEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

     @ManyToOne
     @JoinColumn(name = "employee_id")
    private Employee employee;


}
