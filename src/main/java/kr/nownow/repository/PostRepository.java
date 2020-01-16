package kr.nownow.repository;

import kr.nownow.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends JpaRepository<Post, Long>, PostSupportRepository, QuerydslPredicateExecutor<Post> {

}
