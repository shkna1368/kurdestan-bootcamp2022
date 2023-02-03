package com.kurdestan.resilienc4j.bulkhead;

import com.kurdestan.resilienc4j.time_limiter.TLPostClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class BhService {
    @Autowired
    BHTPPostClient bhtpPostClient;


     @Bulkhead(name="bht-service", type=Bulkhead.Type.THREADPOOL,fallbackMethod ="getDefault" )
    CompletableFuture<String> callApi(Long id){

        return  CompletableFuture.completedFuture(bhtpPostClient.getPost(id));
    }

    CompletableFuture<String> getDefault( Exception e) {
        System.out.println("Default thread pool default");
        return CompletableFuture.completedFuture("Default thread pool default."+e.getMessage());
    }
}
