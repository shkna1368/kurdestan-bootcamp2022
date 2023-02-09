package com.kurdestan.dboptimize.clients;

import com.kurdestan.dboptimize.application.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Table(name = "clients")
@Data

public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @NotNull
    @Column(name = "family",nullable = false)
    private String family;


    @NotNull
    @Column(name = "email",nullable = false)
    private String email;


    @ManyToOne
    private Company company;

}
