package kr.nownow.repository;

import kr.nownow.domain.Post;

import java.util.List;

public interface PostSupportRepository {

    List<Post> findRecentlyPost(long limit);

    List<Post> findPostByUserId(Long userId);

}
