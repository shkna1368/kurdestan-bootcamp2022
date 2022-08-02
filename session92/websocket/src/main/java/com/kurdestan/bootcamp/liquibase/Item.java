package com.kurdestan.bootcamp.liquibase;


import javax.persistence.*;

import lombok.Data;

/**
 * @author Julius Krah
 */
@Data
@Entity
@Table(name = "tbl_item")
public class Item  {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    private House house;
}