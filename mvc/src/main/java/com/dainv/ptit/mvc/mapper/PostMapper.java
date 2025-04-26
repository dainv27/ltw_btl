package com.dainv.ptit.mvc.mapper;

import com.dainv.ptit.mvc.entity.Post;
import com.dainv.ptit.mvc.model.NewPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post fromNewPost(NewPost newPost);
}
