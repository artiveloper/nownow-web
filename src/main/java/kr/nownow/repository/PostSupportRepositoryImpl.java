package kr.nownow.repository;

import kr.nownow.domain.Post;
import kr.nownow.domain.QPost;
import kr.nownow.domain.QUser;
import kr.nownow.domain.Status;
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
                .where(post.status.in(Status.requesting, Status.trading))
                .limit(limit)
                .orderBy(post.createdDate.desc())
                .fetch();
    }

    @Override
    public List<Post> findPostByUserId(Long userId, Long postId) {
        final QPost post = QPost.post;
        return from(post)
                .where(post.writer.id.eq(userId))
                .where(post.id.ne(postId))
                .limit(6)
                .fetch();
    }

}
