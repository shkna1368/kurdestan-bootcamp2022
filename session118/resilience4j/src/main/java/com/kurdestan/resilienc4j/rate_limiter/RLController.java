package com.kurdestan.resilienc4j.rate_limiter;

import com.kurdestan.resilienc4j.circuit_breaker.CBPostClient;
import com.kurdestan.resilienc4j.common.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rl")
public class RLController {

    @Autowired
    RLPostClient postClient;

    @GetMapping(value = "/getPost/{id}")
    private ResponseEntity<String> getPost(@PathVariable Long id){
        String postDTO=postClient.getPost(id);
       return  ResponseEntity.ok(postDTO);


    }
}
