package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.common.BaseEntity;
import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.post_employee.PostEmployee;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_posts")
@Data
@Audited
public class Post  extends BaseEntity {



    @NotNull
    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "post",cascade = CascadeType.ALL)
    private List<PostEmployee> postEmployeeList;


}
