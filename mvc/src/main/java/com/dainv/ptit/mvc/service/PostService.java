package com.dainv.ptit.mvc.service;

import com.dainv.ptit.mvc.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getLatestPosts();
    Optional<Post> get(Long id);
}
