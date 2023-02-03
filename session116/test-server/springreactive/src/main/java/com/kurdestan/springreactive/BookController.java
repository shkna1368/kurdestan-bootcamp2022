package com.kurdestan.springreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/")
    public Flux<Book> getBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("/{id}")
    public Map<String,Object> getBooks(@PathVariable Long id) {
        System.out.println(id);
        Map<String,Object> m=new HashMap<>();
        m.put("id",id);
        m.put("title","AccManaer");
        return m;
    }

     @GetMapping("/tl/{id}")
    public Map<String,Object> getBooks2(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(9000);
        Map<String,Object> m=new HashMap<>();
        m.put("id",id);
        m.put("title","AccManaer");
        return m;
    }





}
