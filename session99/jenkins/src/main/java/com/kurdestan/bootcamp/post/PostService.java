package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.common.exception.NotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostService implements IPostService {


    private  final PostRepository repository;






    @Override
    public Post save(Post post) {

        return repository.save(post);
    }


    public void delete(Long id) {


        repository.deleteById(id);
    }

    public Post getById(Long id) {
        Optional<Post> optionalPost=repository.findById(id);

        if (!optionalPost.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalPost.get();
    }

    @Override

    public List<Post> getAll() {
        return (List<Post>) repository.findAll();
    }



}
