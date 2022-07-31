package com.kurdestan.bootcamp.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PostIntegrationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

 @Autowired
    private ObjectMapper objectMapper;



    @BeforeEach
    void setup(){
postRepository.deleteAll();
    }

    @Test
    public void givenPostObject_whenCreatePost_thenReturnSavedPost() throws Exception{

        // given - precondition or setup
        Post post=new Post();
        post.setTitle("Manger");

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/post/v1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post)));



        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated());


    }
    @Test
    public void givenListOfPosts_whenGetAllPost_thenReturnPostList() throws Exception{
        // given - precondition or setup

        Post post=new Post();
        post.setTitle("Manger2");
        Post post2=new Post();
        post2.setTitle("Security2");



        List<Post> posts=List.of(post,post2);

      postRepository.saveAll(posts);


        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/post/v1")
                        .accept(MediaType.APPLICATION_JSON));


        // then - verify the output
         response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))

                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$[0].title", Matchers.is("Manger2")));


    }


}
