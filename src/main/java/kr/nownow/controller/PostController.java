package kr.nownow.controller;

import kr.nownow.dto.PostDetailDto;
import kr.nownow.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public String detail(Model model, @PathVariable Long postId) {

        PostDetailDto post = new PostDetailDto(postService.getPost(postId));
        List<PostDetailDto> postsOfUser = postService.getAnotherPosts(post.getWriterId(), postId);

        model.addAttribute("post", post);
        model.addAttribute("postsOfUser", postsOfUser);

        return "posts/detail";
    }

}
