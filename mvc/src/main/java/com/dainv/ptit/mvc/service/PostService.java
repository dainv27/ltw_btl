package com.dainv.ptit.mvc.service;

import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.model.NewPost;
import com.dainv.ptit.mvc.model.PostStatus;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Page<Post> getLatestPosts(Integer page, Integer limit);
    Page<Post> getLatestByCategoryId(Long categoryId, Integer page, Integer limit);
    Page<Post> getLatestPostsByAuthorId(String authorId, Integer page, Integer limit);
    Optional<Post> getById(Long id);
    Page<Post> getLatestPostsByStatus(Integer page, Integer limit);
    Page<Post> getLatestTrendingPosts(Integer page, Integer limit);
    Page<Post> getLatestPostsByAuthorIdAndStatusIs(String authorId, PostStatus postStatus, Integer page, Integer limit);
    void create(NewPost post);
}
