package kr.nownow.repository;

import kr.nownow.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Transactional
    @Test
    void name() {
        List<Post> all = postRepository.findAllIsShow();

        all.forEach(post -> {
            System.out.println(post.getTitle());
            System.out.println(post.getWriter().getNickname());
            System.out.println("");
        });
    }

}