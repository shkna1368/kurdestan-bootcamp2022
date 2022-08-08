package com.kurdestanbootcamp.postemployeeservice.post_client;


import com.kurdestanbootcamp.postemployeeservice.common.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post", url = "http://localhost:8080/postservice/post", configuration = FeignConfig.class)
public interface  PostClient {

    @GetMapping(value = "/v1/{postId}")
    PostDTO getPost(@PathVariable(value = "postId")   Long postId);
}
