package com.kurdestan.bootcamp.async;


import com.kurdestan.bootcamp.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "users", url = "https://api.github.com/users/", configuration = FeignConfig.class)

public interface GitHubLookupClient {
    @GetMapping(value = "/{user}")
    User getUser(@PathVariable String user);






}
