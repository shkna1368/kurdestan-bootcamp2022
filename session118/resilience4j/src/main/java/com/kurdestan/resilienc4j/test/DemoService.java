package com.kurdestan.resilienc4j.test;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DemoService {

    @CircuitBreaker(name = "cb-instanceA",fallbackMethod = "cbFallBack")
    public String circuitBreaker() {
        return cbRemoteCall();
    }

    private String cbRemoteCall() {
        double random = Math.random();
        //should fail more than 70% of time
        if (random <= 0.7) {
            throw new RuntimeException("CB Remote Call Fails");
        }
        return "CB Remote Call Executed";
    }

    public String cbFallBack(Exception exception) {
        return String.format("Fallback Execution for Circuit Breaker. Error Message: %s\n",exception.getMessage());
    }

    @RateLimiter(name = "rl-instanceA")
    public String rateLimiter() {
        return "Executing Rate Limited Method";
    }

    @TimeLimiter(name = "tl-instanceA")
    public CompletableFuture<String> timeLimiter() {
        return CompletableFuture.supplyAsync(this::timeLimiterRemoteCall);
    }

    private String timeLimiterRemoteCall() {
        //Will fail 50% of the time
        double random = Math.random();
        if (random < 0.5) {
            return "Executing Time Limited Call...";
        } else {
            try {
                System.out.println("Delaying Execution");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Exception Will be Raised";
    }

    @Retry(name = "re-instanceA",fallbackMethod = "me")
    public String retry() {
        return retryRemoteCall();
    }

    String me(Exception e){
        return "default retry"+e.getMessage();
    }

    private String retryRemoteCall() {
        //will fail 80% of the time
        double random = Math.random();
        System.out.println("call retry"+random);
        System.out.println("--------------");

        if (random <= 0.8) {
            throw new RuntimeException("Retry Remote Call Fails");
        }

        return  "Executing Retry Remote Call";
    }

    @Bulkhead(name = "tp-instanceA", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> bulkHead() {
        return CompletableFuture.completedFuture("Executing Bulk Head Remote call");
    }
}