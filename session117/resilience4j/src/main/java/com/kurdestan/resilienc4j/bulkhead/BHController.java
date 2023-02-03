package com.kurdestan.resilienc4j.bulkhead;

import com.kurdestan.resilienc4j.common.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/bh")
public class BHController {

    @Autowired
    BHSFPostClient bhsfPostClient;

 @Autowired
    BhService bhService;



    @GetMapping(value = "/tp/{id}")
    private ResponseEntity<String> getPostTP(@PathVariable Long id) throws ExecutionException, InterruptedException {
       ;
        return  ResponseEntity.ok( bhService.callApi(id).get());


    }



    @GetMapping(value = "/sm/{id}")
    private ResponseEntity<String> getPostSm(@PathVariable Long id) throws ExecutionException, InterruptedException {
    //Thread.sleep(4000);
      //  System.out.println(Thread.currentThread());
     String postDTO=bhsfPostClient.getPost(id);
        return  ResponseEntity.ok(postDTO);
    }


}
