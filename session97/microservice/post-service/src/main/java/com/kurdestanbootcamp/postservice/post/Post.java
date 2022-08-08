package com.kurdestanbootcamp.postservice.post;

import com.kurdestanbootcamp.postservice.common.BaseEntity;
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



}
