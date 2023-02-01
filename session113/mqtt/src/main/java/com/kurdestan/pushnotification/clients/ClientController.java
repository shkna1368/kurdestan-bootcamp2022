package com.kurdestan.pushnotification.clients;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client/")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;



    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody Client client){

        clientService.register(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id ){

        var client=    clientService.getById(id);
        return ResponseEntity.ok(client);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.ok( clientService.getAll());
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){


        return ResponseEntity.ok().build();
    }



}
