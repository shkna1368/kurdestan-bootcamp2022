package com.kurdestanbootcamp.employeeservice.common.exception;

public class NotFoundException  extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }
}
