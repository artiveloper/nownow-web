package kr.nownow.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Transactional
    @Test
    void list() {
        /*List<Post> all = postRepository.findRecentlyPost(10L);

        all.forEach(post -> {
            System.out.println(post.getTitle());
            System.out.println(post.getWriter().getNickname());
            System.out.println(post.getCreatedDate());
            System.out.println("");
        });*/
    }

    @Test
    void detail() throws Exception {
        /*List<Post> postByUserId = postRepository.findPostByUserId(1L, 1L);
        for (Post post : postByUserId) {
            System.out.println(post.getTitle());
            System.out.println(post.getContent());
            System.out.println("");
        }*/
    }

    @Test
    void name() throws Exception {
        String image = "https://res.cloudinary.com/dgmnmk1g2/image/upload/v1569940395/nownow/cwk2tvkpxtlgrztd6jsr.jpg";

        String[] splits = image.split("/upload");

        String com = splits[0] + "/upload/c_scale,h_300,w_300/" + splits[1];

        System.out.println(com);

    }
}