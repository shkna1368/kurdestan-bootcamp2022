package com.kurdestanbootcamp.graphql.qraphql;

import com.kurdestanbootcamp.graphql.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "ratings")
@Data
@Audited

public class Rating extends BaseEntity {


    @NotNull
    @Column(name = "rate",nullable = false)
    private String rate;

    @NotNull
    @Column(name = "star",nullable = false)
    private String star;



}
