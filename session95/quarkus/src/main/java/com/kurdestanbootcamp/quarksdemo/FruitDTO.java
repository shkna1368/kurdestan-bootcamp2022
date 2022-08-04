package com.kurdestanbootcamp.quarksdemo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class FruitDTO {


    private Long id;

    @NotNull
    @NotEmpty
    private String name;


    @NotNull
    @NotEmpty
    private String color;


}