package com.kurdestan.resilienc4j.common.exception;

import feign.FeignException;

public class FeignCustomException extends FeignException {
    protected FeignCustomException(int status, String message) {
        super(status, message);
    }
}
