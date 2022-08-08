package com.kurdestanbootcamp.postservice.post;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostDTO postDTO);
    PostDTO toPostDTO(Post post);

    List<PostDTO> toPostDTOs(List<Post> posts);

}
