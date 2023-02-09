package com.kurdestan.dboptimize.application;

import com.kurdestan.dboptimize.clients.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "companys")
@Data

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="foo_sequence")
    @SequenceGenerator(name="foo_sequence", sequenceName = "foo_id_seq", allocationSize = 100)
    private Long id;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;



    @NotNull
    @Column(name = "email",nullable = false)
    private String email;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Client> clientList;
    @Version
  private   int version=0;

}
