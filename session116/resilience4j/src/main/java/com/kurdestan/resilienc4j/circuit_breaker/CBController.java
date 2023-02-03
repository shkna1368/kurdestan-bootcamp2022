package com.kurdestan.resilienc4j.circuit_breaker;

import com.kurdestan.resilienc4j.common.PostDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cb")
public class CBController {

    @Autowired
    private   CBPostClient cbPostClient;

    @GetMapping(value = "/getPost/{id}")
    private ResponseEntity<String> getPost(@PathVariable Long id){
        String postDTO=cbPostClient.getPost(id);
       return  ResponseEntity.ok(postDTO);

    }


}
