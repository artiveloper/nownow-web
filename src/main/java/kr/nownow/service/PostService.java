package kr.nownow.service;

import kr.nownow.domain.Post;
import kr.nownow.dto.PostDetailDto;
import kr.nownow.exception.PostNotFoundException;
import kr.nownow.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public List<PostDetailDto> getRecentlyListWithLimit(Long limit) {
        return postRepository.findRecentlyPost(limit)
                .stream()
                .map(PostDetailDto::new)
                .collect(Collectors.toList());

    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException("해당 게시물을 찾을 수 없습니다."));
    }

    public List<PostDetailDto> getAnotherPosts(Long userId, Long postId) {
        return postRepository.findPostByUserId(userId, postId)
                .stream()
                .map(PostDetailDto::new)
                .collect(Collectors.toList());
    }

}
