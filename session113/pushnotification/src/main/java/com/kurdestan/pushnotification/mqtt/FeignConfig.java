package com.kurdestan.pushnotification.mqtt;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import com.kurdestan.pushnotification.common.CustomApiErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class FeignConfig {
    @Value("${EMQX.API_KEY}")
    private String apiKey;

     @Value("${EMQX.API_SECRET}")
    private String apiSecret;



    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(apiKey, apiSecret);
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomApiErrorDecoder();
    }
}