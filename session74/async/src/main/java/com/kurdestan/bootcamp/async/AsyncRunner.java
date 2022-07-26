package com.kurdestan.bootcamp.async;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@AllArgsConstructor
public class AsyncRunner implements CommandLineRunner {

    private final GitHubLookupService gitHubLookupService;



    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
        CompletableFuture<User> page4 = gitHubLookupService.findUserWithFeign("shkna1368");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3,page4).join();

        // Print results, including elapsed time

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));

        System.out.println("Page1:"+page1.get());
        System.out.println("Page2:"+page2.get());
        System.out.println("Page3:"+page3.get());
        System.out.println("Page4"+page4.get());



    }

}

