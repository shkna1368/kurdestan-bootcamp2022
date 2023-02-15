package com.kurdestanbootcamp.graphql.qraphql;

import com.kurdestanbootcamp.graphql.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "authord")
@Data
@Audited
public class Author extends BaseEntity {


    @NotNull
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name",nullable = false)
    private String lastName;




}
