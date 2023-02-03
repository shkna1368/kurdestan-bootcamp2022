package com.kurdestan.resilienc4j.retry;

import com.kurdestan.resilienc4j.common.PostDTO;
import com.kurdestan.resilienc4j.rate_limiter.RLPostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rt")
public class RTController {

    @Autowired
    RetService retService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<String> getPost(@PathVariable Long id){
        String postDTO=retService.callApi(id);
       return  ResponseEntity.ok(postDTO);


    }
}
