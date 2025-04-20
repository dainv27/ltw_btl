package com.dainv.ptit.mvc.service.impl;

import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.repository.PostRepository;
import com.dainv.ptit.mvc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepo;

    @Override
    public Page<Post> getLatestPosts(Integer page, Integer limit) {
        return postRepo.findAll(PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }

    @Override
    public Page<Post> getLatestByCategoryId(Long categoryId, Integer page, Integer limit) {
        return postRepo.findAllByCategoryId(categoryId, PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepo.findById(id);
    }

    @Override
    public Page<Post> getLatestPostsByAuthorId(String authorId, Integer page, Integer limit) {
        return postRepo.findByAuthorId(authorId, PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }
}
