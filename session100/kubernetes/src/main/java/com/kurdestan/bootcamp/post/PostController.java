package com.kurdestan.bootcamp.post;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post/")
@AllArgsConstructor
public class PostController {

    private final IPostService service;
    private PostMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PostDTO postDTO){
    Post post=mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id ){

    Post post=    service.getById(id);
    PostDTO postDTO=mapper.toPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }

    @Timed("post.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<PostDTO>> getAll(){

    List<Post> posts=    service.getAll();


    List<PostDTO> postDTOS=    mapper.toPostDTOs(posts);


        return ResponseEntity.ok(postDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }



}
