package kr.nownow.controller;

import kr.nownow.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final PostService postService;

    @GetMapping("/")
    public String welcome(Model model) {

        return "index";
    }

}
