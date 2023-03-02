package com.kurdestanbootcamp.postgis.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdvertiseDTO implements Serializable {


    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    private String title;



    private Integer inStock;
private LocationDTO locationDTO;



}
