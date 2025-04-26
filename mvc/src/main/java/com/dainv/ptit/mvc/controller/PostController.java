package com.dainv.ptit.mvc.controller;

import com.dainv.ptit.mvc.entity.Category;
import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.entity.User;
import com.dainv.ptit.mvc.model.NewPost;
import com.dainv.ptit.mvc.model.PostStatus;
import com.dainv.ptit.mvc.model.UserDetailSec;
import com.dainv.ptit.mvc.repository.UserRepository;
import com.dainv.ptit.mvc.service.CategoryService;
import com.dainv.ptit.mvc.service.PostService;
import com.dainv.ptit.mvc.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("/posts")
    public String getPost(@RequestParam(name = "category") Long categoryId, Model model){
        Page<Post> posts = postService.getLatestByCategoryId(categoryId, 0, 10);
        model.addAttribute("posts", posts.getContent());
        return "category-posts";
    }

    @GetMapping("/posts/{id}")
    public String readPost(@PathVariable(name = "id") Long id, Model model){
        Post post = postService.getById(id).orElse(null);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/new-post")
    public String newPost(Model model){
        Page<Category> categories = categoryService.findAll(0, 10);
        model.addAttribute("categories", categories.getContent());

        return "new-post";
    }

    @GetMapping("/my-posts")
    public String myPosts(Model model){
        UserDetailSec userDetailSec = (UserDetailSec) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<Post> publishedPosts = postService.getLatestPostsByAuthorIdAndStatusIs(userDetailSec.getId(), PostStatus.PUBLISHED, 0, 10);
        Page<Post> draftPosts = postService.getLatestPostsByAuthorIdAndStatusIs(userDetailSec.getId(), PostStatus.DRAFT, 0, 10);
        Page<Post> waitingPosts = postService.getLatestPostsByAuthorIdAndStatusIs(userDetailSec.getId(), PostStatus.WAITING_FOR_APPROVAL, 0, 10);
        Page<Post> approvedPosts = postService.getLatestPostsByAuthorIdAndStatusIs(userDetailSec.getId(), PostStatus.APPROVED, 0, 10);

        model.addAttribute("publishedPosts", publishedPosts.getContent());
        model.addAttribute("draftPosts", draftPosts.getContent());
        model.addAttribute("waitingPosts", waitingPosts.getContent());
        model.addAttribute("approvedPosts", approvedPosts.getContent());

        return "my-posts";
    }

    @PostMapping("/new-post")
    public String createPost(Authentication authentication, @ModelAttribute NewPost post) throws BadRequestException {
        UserDetailSec userDetailSec = (UserDetailSec) authentication.getPrincipal();
        User user = userService.getUser(userDetailSec.getId()).orElseThrow(BadRequestException::new);
        post.setAuthor(user);
        postService.create(post);
        return "redirect:/my-posts";
    }
}
