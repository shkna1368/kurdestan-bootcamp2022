package com.kurdestanbootcamp.quarksdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Fruit {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String color;


}