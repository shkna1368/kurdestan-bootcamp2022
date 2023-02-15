package com.kurdestanbootcamp.graphql.qraphql;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

   @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }


   // @SchemaMapping(typeName = "Query", value="findOne")

    @QueryMapping
    public Book findOne(@Argument Long id) {
        return bookRepository.findById(id).get();
    }

}
