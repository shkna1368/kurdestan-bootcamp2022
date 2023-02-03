package com.kurdestan.resilienc4j.time_limiter;

import com.kurdestan.resilienc4j.circuit_breaker.CBPostClient;
import com.kurdestan.resilienc4j.common.PostDTO;
import feign.AsyncFeign;
import feign.codec.Decoder;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "/tl")
public class TimeLimiterController {
@Autowired
Tservice tservice;
   /* @Autowired
    TLPostClient postClient;*/

   // @Bulkhead(name="postClinetTLBH", type=Bulkhead.Type.THREADPOOL)
    @GetMapping(value = "/{id}")
   // @TimeLimiter(name="postClinetTL",fallbackMethod = "getDefault")

    private String getPost(@PathVariable Long id) throws ExecutionException, InterruptedException {

 /*  return   CompletableFuture.supplyAsync(new Supplier<String>() {


        @Override
        public String get() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return     "postClient.getPost(id)";

        }
    });

*/

    /*  String  post = AsyncFeign.asyncBuilder()
                .decoder(new Decoder.Default())
                .target(TLPostClient.class,"http://localhost:8081/").getPost(id);

*/


            // String post=postClient.getPost(id).get();

return tservice.callApi(id).get();

    }

     String getDefault( Exception e) {
        return "Default time limiter";
    }
}
