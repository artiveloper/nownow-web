package kr.nownow.controller;

import kr.nownow.domain.Post;
import kr.nownow.dto.PostDetailDto;
import kr.nownow.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final PostService postService;

    @GetMapping("/")
    public String welcome(Model model) {
        Long limit = 12L;
        List<PostDetailDto> recentlyPosts = postService.getRecentlyListWithLimit(limit);

        model.addAttribute("recentlyPosts", recentlyPosts);
        return "index";
    }

}
