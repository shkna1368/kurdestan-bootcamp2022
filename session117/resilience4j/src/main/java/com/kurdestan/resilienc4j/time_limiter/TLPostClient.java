package com.kurdestan.resilienc4j.time_limiter;


import com.kurdestan.resilienc4j.common.FeignConfig;
import com.kurdestan.resilienc4j.common.PostDTO;
import feign.Param;
import feign.RequestLine;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.CompletableFuture;



@FeignClient(name = "postTL", url = "http://localhost:8081/", configuration = FeignConfig.class)
public interface TLPostClient {


    //@TimeLimiter(name="postClinetTL",fallbackMethod = "getDefault")
    @GetMapping(value = "/tl/{postId}")
    //@RequestLine("GET /tl/{postId}")
    //String  getPost(@Param(value = "postId")   Long postId);
    String  getPost(@PathVariable(value = "postId")   Long postId);


}
