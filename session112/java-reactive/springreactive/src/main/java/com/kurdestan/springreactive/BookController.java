package com.kurdestan.springreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
}
