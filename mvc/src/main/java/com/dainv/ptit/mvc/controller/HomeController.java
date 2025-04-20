package com.dainv.ptit.mvc.controller;

import com.dainv.ptit.mvc.entity.Category;
import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.service.CategoryService;
import com.dainv.ptit.mvc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CategoryService categoryService;
    private final PostService postService;

    @GetMapping("/")
    public String home(Model model){
        Page<Category> categories = categoryService.findAll(0, 10);
        model.addAttribute("categories", categories);

        Page<Post> posts = postService.getLatestPosts(0, 10);
        model.addAttribute("posts", posts.getContent());
        return "home";
    }
}
