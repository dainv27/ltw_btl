package com.dainv.ptit.mvc.controller;

import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PostService postService;

    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postService.getLatestPosts();
        model.addAttribute("posts", posts);
        return "home";
    }
}
