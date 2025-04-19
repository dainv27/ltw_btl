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
    public List<Post> getLatestPosts() {
        Page<Post> posts = postRepo.findAll(PageRequest.of(0, 10, Sort.by("createdTime")));
        return posts.getContent();
    }

    @Override
    public Optional<Post> get(Long id) {
        return postRepo.findById(id);
    }
}
