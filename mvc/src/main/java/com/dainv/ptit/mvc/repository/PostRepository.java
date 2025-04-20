package com.dainv.ptit.mvc.repository;

import com.dainv.ptit.mvc.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByAuthorId(String authorId, Pageable pageable);
    Page<Post> findAllByCategoryId(Long categoryId, Pageable pageable);
}
