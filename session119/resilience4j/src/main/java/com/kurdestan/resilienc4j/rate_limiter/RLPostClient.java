package com.kurdestan.resilienc4j.rate_limiter;


import com.kurdestan.resilienc4j.common.FeignConfig;
import com.kurdestan.resilienc4j.common.PostDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "postRl", url = "http://localhost:8081", configuration = FeignConfig.class)
public interface RLPostClient {

    @RateLimiter(name="postClientRateLimiter",fallbackMethod = "getDefault")
    @GetMapping(value = "/{postId}")
    String getPost(@PathVariable(value = "postId")   Long postId);

    default String getDefault(Exception e){
        return "fallback ratelimitter"+e.getMessage();
    }

}
