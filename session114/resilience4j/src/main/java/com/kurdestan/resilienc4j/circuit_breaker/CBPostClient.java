package com.kurdestan.resilienc4j.circuit_breaker;


import com.kurdestan.resilienc4j.common.FeignConfig;
import com.kurdestan.resilienc4j.common.PostDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "postClientCB", url = "http://localhost:8081/", configuration = FeignConfig.class)
public interface CBPostClient {

    @GetMapping(value = "/{postId}")
    @CircuitBreaker(name="postClientCB", fallbackMethod = "getDefault")
    String getPost(@PathVariable(value = "postId")   Long postId);

    default String getDefault(Exception e){
        return "not available"+e.getMessage();
    }

}
