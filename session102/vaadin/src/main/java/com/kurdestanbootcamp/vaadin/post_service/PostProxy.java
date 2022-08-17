package com.kurdestanbootcamp.vaadin.post_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "post",url = "http://localhost:8090/post")
public interface PostProxy {

    @GetMapping("/v1")
    List<PostDTO> getAll();

    @PostMapping("/v1")
   void save(@RequestBody  PostDTO postDTO);





}
