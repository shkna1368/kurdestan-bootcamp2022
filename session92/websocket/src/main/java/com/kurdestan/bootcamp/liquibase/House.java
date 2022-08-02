package com.kurdestan.bootcamp.liquibase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Julius Krah
 */
@Data
@Entity
@Table(name = "tbl_house")
public class House  {
    @Id
    @GeneratedValue
    private Integer id;
    private String owner;
    private boolean fullyPaid;
}