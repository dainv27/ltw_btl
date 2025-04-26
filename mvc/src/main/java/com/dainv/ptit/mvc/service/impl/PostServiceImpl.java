package com.dainv.ptit.mvc.service.impl;

import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.mapper.PostMapper;
import com.dainv.ptit.mvc.model.NewPost;
import com.dainv.ptit.mvc.model.PostStatus;
import com.dainv.ptit.mvc.repository.PostRepository;
import com.dainv.ptit.mvc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepo;
    private final PostMapper postMapper;

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
    public Page<Post> getLatestPostsByStatus(Integer page, Integer limit) {
        return postRepo.findAllByStatusIs(PostStatus.PUBLISHED, PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }

    @Override
    public Page<Post> getLatestTrendingPosts(Integer page, Integer limit) {
        return postRepo.findAllByStatusIs(PostStatus.PUBLISHED, PageRequest.of(page, limit, Sort.by("rate", "createdTime").descending()));
    }

    @Override
    public Page<Post> getLatestPostsByAuthorIdAndStatusIs(String authorId, PostStatus postStatus, Integer page, Integer limit) {
        return postRepo.findByAuthorIdAndStatusIs(authorId, postStatus, PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }

    @Override
    public void create(NewPost post) {
        postRepo.save(postMapper.fromNewPost(post));
    }

    @Override
    public Page<Post> getLatestPostsByAuthorId(String authorId, Integer page, Integer limit) {
        return postRepo.findByAuthorId(authorId, PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }
}
