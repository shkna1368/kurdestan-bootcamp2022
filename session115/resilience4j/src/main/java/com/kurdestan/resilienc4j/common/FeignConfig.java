package com.kurdestan.resilienc4j.common;

import com.kurdestan.resilienc4j.common.exception.CustomApiErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

   /* @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }*/
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomApiErrorDecoder();
    }






}