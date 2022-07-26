package com.kurdestan.bootcamp.config;

import com.kurdestan.bootcamp.common.exception.AccessDeniedException;
import com.kurdestan.bootcamp.common.exception.BadRequestException;
import com.kurdestan.bootcamp.common.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomApiErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {


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