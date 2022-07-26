package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.employee.EmployeeMapper;
import com.kurdestan.bootcamp.family.Family;
import com.kurdestan.bootcamp.family.FamilyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostDTO postDTO);
    PostDTO toPostDTO(Post post);

    List<PostDTO> toPostDTOs(List<Post> posts);

}
