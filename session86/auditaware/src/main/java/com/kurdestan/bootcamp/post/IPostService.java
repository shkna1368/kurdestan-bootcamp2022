package com.kurdestan.bootcamp.post;

import java.util.List;

public interface IPostService {

    Post save(Post post);
    void delete(Long id);
    Post getById(Long id);
    List<Post> getAll();


}
