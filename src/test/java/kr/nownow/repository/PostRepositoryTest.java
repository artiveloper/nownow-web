package kr.nownow.repository;

import kr.nownow.domain.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Transactional
    @Test
    void name() {
        List<Post> all = postRepository.findRecentlyPost(10L);

        all.forEach(post -> {
            System.out.println(post.getTitle());
            System.out.println(post.getWriter().getNickname());
            System.out.println(post.getCreatedDate());
            System.out.println("");
        });

    }

}