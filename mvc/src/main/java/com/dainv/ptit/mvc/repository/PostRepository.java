package com.dainv.ptit.mvc.repository;

import com.dainv.ptit.mvc.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
