package com.kurdestan.resilienc4j.retry;

import com.kurdestan.resilienc4j.time_limiter.TLPostClient;
import feign.FeignException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RetService {
    @Autowired
    RTPostClient postClient;


  //  @RateLimiter(name="postClientRetry",fallbackMethod = "getDefault")
    String callApi(Long id){
        return postClient.getPost(id);

        //  return  calls(id);
      //  return  retryRemoteCall();
    }
    String getDefault( Exception e) {

        return "Default retry";
    }

    public String calls(Long id){
        System.out.println("call api"+id);
try {
    return postClient.getPost(id);

}
catch (FeignException feignException ){
    throw new RuntimeException("not available");
}

    }

    private String retryRemoteCall() {

        System.out.println("retry call");
        //will fail 80% of the time
        double random = Math.random();
        if (random <= 0.8) {
            throw new RuntimeException("Retry Remote Call Fails");
        }
        return  "Executing Retry Remote Call";
    }
}
