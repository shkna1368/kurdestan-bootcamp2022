package com.kurdestanbootcamp.graphql.qraphql;

import com.kurdestanbootcamp.graphql.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "books")
@Data
@Audited
public class Book extends BaseEntity {


    @NotNull
    @Column(name = "title",nullable = false)
    private String title;

    @NotNull
    @Column(name = "pages",nullable = false)
    private Integer pages;


@ManyToOne
  private   Author author;


@OneToOne
  private   Rating rating;


}
