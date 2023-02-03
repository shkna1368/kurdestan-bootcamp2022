package com.kurdestan.resilienc4j.time_limiter;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

@Service
public class Tservice {
    @Autowired
    TLPostClient postClient;


     @Bulkhead(name="postClinetTLBH", type=Bulkhead.Type.THREADPOOL)
    @TimeLimiter(name="postClinetTL",fallbackMethod = "getDefault")
    CompletableFuture<String> callApi(Long id){

        return  CompletableFuture.completedFuture(postClient.getPost(id));
    }
    CompletableFuture<String> getDefault( Exception e) {
        return CompletableFuture.completedFuture("Default time limiter."+e.getMessage());
    }
}
