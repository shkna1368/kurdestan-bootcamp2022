package com.kurdestan.bootcamp.post;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostServiceTest {
    @Mock
    PostRepository repository;

    @InjectMocks
    PostService postService;

  /*  @BeforeEach
    void initUseCase() {
        postService = new PostService(repository);
    }*/
    @Order(1)
    @Test
    public void save() throws Exception {

       Post post=new Post();
       post.setTitle("Manger");


        when(repository.save(any(Post.class))).thenReturn(post);

        Post savedPost =postService.save(post);


        assertNotNull(savedPost);
        Assert.assertEquals(post.getTitle(),savedPost.getTitle());
    }

    @Order(2)
    @Test
    public void findAllTest() throws Exception {

        Post post=new Post();
        post.setTitle("Manger");
        Post post2=new Post();
        post2.setTitle("Security");




        List<Post> posts=List.of(post,post2);



        when(repository.findAll()).thenReturn(posts);


        List<Post> queryResult = (List<Post>) postService.getAll();

        assertFalse(queryResult.isEmpty());
        assertNotNull(queryResult.get(0));
    }


}

