package com.kurdestan.bootcamp.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {

    private String key;
    private Object value;
    private  SearchOperation operation;

}
