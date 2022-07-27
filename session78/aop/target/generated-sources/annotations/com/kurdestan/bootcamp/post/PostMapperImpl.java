package com.kurdestan.bootcamp.post;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-28T02:37:11+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDTO.getId() );
        post.setVersion( postDTO.getVersion() );
        post.setCreatedDate( postDTO.getCreatedDate() );
        post.setCreatedBy( postDTO.getCreatedBy() );
        post.setLastModifiedDate( postDTO.getLastModifiedDate() );
        post.setLastModifiedBy( postDTO.getLastModifiedBy() );
        post.setTitle( postDTO.getTitle() );

        return post;
    }

    @Override
    public PostDTO toPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setVersion( post.getVersion() );
        postDTO.setCreatedDate( post.getCreatedDate() );
        postDTO.setCreatedBy( post.getCreatedBy() );
        postDTO.setLastModifiedDate( post.getLastModifiedDate() );
        postDTO.setLastModifiedBy( post.getLastModifiedBy() );
        postDTO.setId( post.getId() );
        postDTO.setTitle( post.getTitle() );

        return postDTO;
    }

    @Override
    public List<PostDTO> toPostDTOs(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( posts.size() );
        for ( Post post : posts ) {
            list.add( toPostDTO( post ) );
        }

        return list;
    }
}
