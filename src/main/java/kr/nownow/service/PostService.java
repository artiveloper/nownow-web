package kr.nownow.service;

import kr.nownow.domain.Post;
import kr.nownow.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getRecentlyListWithLimit(Long limit) {
        return postRepository.findRecentlyPost(limit);
    }

}
