package com.dainv.ptit.mvc.service;

import com.dainv.ptit.mvc.entity.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Page<Post> getLatestPosts(Integer page, Integer limit);
    Page<Post> getLatestByCategoryId(Long categoryId, Integer page, Integer limit);
    Page<Post> getLatestPostsByAuthorId(String authorId, Integer page, Integer limit);
    Optional<Post> getById(Long id);
}
