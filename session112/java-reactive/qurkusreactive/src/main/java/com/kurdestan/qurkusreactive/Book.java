package com.kurdestan.qurkusreactive;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity

public class Book extends PanacheEntity  {

    @Column(length = 40, unique = true)

    public String title;
}
