package com.kurdestan.bootcamp.post;


import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
//unit test
import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRepositoryTest {


    @Autowired
    PostRepository repository;




   @BeforeEach
    void initUseCase() {
        Post post=new Post();
        post.setTitle("Manger");
        Post savedPost =repository.save(post);
    }

    @AfterEach
    public void destroyAll(){
        repository.deleteAll();
    }

    @Order(1)
    @Test
    public void save() throws Exception {

        Post post=new Post();
        post.setTitle("security");
        Post savedPost =repository.save(post);


        assertNotNull(savedPost);

        Assert.assertEquals(post.getTitle(),savedPost.getTitle());
    }

    @Order(2)
    @Test
    public void getAllTest() throws Exception {



        List<Post> all = (List<Post>) repository.findAll();

        assertNotNull(all.get(0));
    }



}
