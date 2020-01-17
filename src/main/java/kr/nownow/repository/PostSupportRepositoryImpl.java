package kr.nownow.repository;

import kr.nownow.domain.Post;
import kr.nownow.domain.QPost;
import kr.nownow.domain.QUser;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PostSupportRepositoryImpl extends QuerydslRepositorySupport implements PostSupportRepository {

    public PostSupportRepositoryImpl() {
        super(Post.class);
    }

    @Override
    public List<Post> findRecentlyPost(long limit) {
        final QPost post = QPost.post;
        return from(post)
                .leftJoin(QPost.post.writer, QUser.user)
                .fetchJoin()
                .limit(limit)
                .orderBy(post.createdDate.desc())
                .fetch();
    }

    @Override
    public List<Post> findPostByUserId(Long id) {
        final QPost post = QPost.post;
        return from(post)
                .where(post.writer.id.eq(id))
                .limit(6)
                .fetch();
    }

}
