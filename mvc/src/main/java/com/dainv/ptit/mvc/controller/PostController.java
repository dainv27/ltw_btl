package com.dainv.ptit.mvc.controller;

import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts/{id}")
    public String readPost(@PathVariable(name = "id") Long id, Model model){
        Post post = postService.get(id).orElse(null);
        model.addAttribute("post", post);
        return "post";
    }
}
