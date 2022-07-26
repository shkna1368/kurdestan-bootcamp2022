package com.kurdestan.bootcamp.async;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookupService {


    private final RestTemplate restTemplate;
    private final GitHubLookupClient gitHubLookupClient;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder,GitHubLookupClient gitHubLookupClient) {
        this.restTemplate = restTemplateBuilder.build();
        this.gitHubLookupClient=gitHubLookupClient;
    }

   @Async("GithubLookup")
    public CompletableFuture<User> findUser(String user) throws InterruptedException {

        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

    @Async("GithubLookup")
    public CompletableFuture<User> findUserWithFeign(String user) throws InterruptedException {


        User results = gitHubLookupClient.getUser(user);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }



}