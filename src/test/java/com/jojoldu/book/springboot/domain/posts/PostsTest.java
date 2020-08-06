package com.jojoldu.book.springboot.domain.posts;

import lombok.RequiredArgsConstructor;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());
        //when
        //방법1
//        Iterable<Posts> postsList = postsRepository.findAll();
//        Posts posts = postsList.iterator().next();
        //방법2
//        Iterable<Posts> iterable = postsRepository.findAll();
//        List<Posts> list = Lists.newArrayList(iterable);
//        Posts posts = list.get(0);


        //CrudRepository의 findAll은 Iterable<T>
        //JpaRepository의 findAll은 List<T>


        List<Posts> postsList = postsRepository.findAll();

        //then
        System.out.println(postsList.toString());
        Posts post1 = postsList.get(0);
        assertThat(post1.getTitle()).isEqualTo(title);
        assertThat(post1.getContent()).isEqualTo(content);

    }

}