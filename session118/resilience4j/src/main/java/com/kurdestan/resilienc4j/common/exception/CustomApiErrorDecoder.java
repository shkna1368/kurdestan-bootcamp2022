package com.kurdestan.resilienc4j.common.exception;


import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

import java.nio.file.AccessDeniedException;


public class CustomApiErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
Exception exception=errorDecoder.decode(methodKey,response);

if (exception instanceof RetryableException){
    return new BadRequestException("not available");
}

        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad Request");
            case 403:
                return new AccessDeniedException("Access Denied");
            case 404:
                return new NotFoundException("Not Fount");

            case 500:
            case 501:
            case 502:
            case 503:
                return new NotFoundException("Not Fount");


            default:
                return new Exception("Generic error");
        }
    }
}