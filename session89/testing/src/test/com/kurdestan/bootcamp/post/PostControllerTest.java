package com.kurdestan.bootcamp.post;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
//@Import(PostControllerTest.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostMapper mapper;
    @MockBean
   private PostService postService;



    @Order(1)
    @Test
    public void testFindAll() throws Exception {

        Post post=new Post();
        post.setTitle("Manger");
        Post post2=new Post();
        post2.setTitle("Security");


  PostDTO postDTO=new PostDTO();
        postDTO.setTitle("Manger2");

        PostDTO postDTO2=new PostDTO();
        postDTO2.setTitle("Security2");




        List<Post> posts=List.of(post,post2);
        List<PostDTO> postDTOS=List.of(postDTO,postDTO2);

        when(postService.getAll()).thenReturn(posts);
        when(mapper.toPostDTOs(posts)).thenReturn(postDTOS);


        // when -  action or the behaviour that we are going test
        ResultActions response = mvc.perform(MockMvcRequestBuilders
                .get("/post/v1")
                .accept(MediaType.APPLICATION_JSON));


        // then - verify the output
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))

                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$[0].title", Matchers.is("Manger2")));







      /*  ResultActions response = mvc.perform(MockMvcRequestBuilders
                .get("/post/v1")
                .accept(MediaType.APPLICATION_JSON));

        mvc.perform(MockMvcRequestBuilders
                        .get("/post/v1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))

                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$[0].title", Matchers.is("Manger")));
*/
        ;
    }
}