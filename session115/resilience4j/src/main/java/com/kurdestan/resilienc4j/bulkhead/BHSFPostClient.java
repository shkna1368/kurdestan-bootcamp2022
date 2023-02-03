package com.kurdestan.resilienc4j.bulkhead;


import com.kurdestan.resilienc4j.common.FeignConfig;
import com.kurdestan.resilienc4j.common.PostDTO;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "postBHS", url = "http://localhost:8081/", configuration = FeignConfig.class)
public interface BHSFPostClient {


    @Bulkhead(name="bhs-service", type=Bulkhead.Type.SEMAPHORE,fallbackMethod = "getDefault")
    @GetMapping(value = "/tl/{postId}")
    String getPost(@PathVariable(value = "postId")   Long postId);

    default String getDefault(Exception e)
    {
        System.out.println("fallback bulkhead semaphore");
        return "fallback bulkhead semaphore."+e.getMessage();
    }

}
