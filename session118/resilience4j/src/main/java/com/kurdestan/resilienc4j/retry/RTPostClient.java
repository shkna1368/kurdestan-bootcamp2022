package com.kurdestan.resilienc4j.retry;


import com.kurdestan.resilienc4j.common.FeignConfig;
import com.kurdestan.resilienc4j.common.PostDTO;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "postRe", url = "http://localhost:8081/", configuration = FeignConfig.class)
public interface RTPostClient {

   // @Bulkhead(name="postClinetRetBH", type=Bulkhead.Type.THREADPOOL)
   @Retry(name="postClientRetry",fallbackMethod = "getDefault")
   @GetMapping(value = "/{postId}")
    String getPost(@PathVariable(value = "postId")   Long postId);

    default String getDefault(Exception e){
        return "fallback retry"+e.getMessage();
    }

}
