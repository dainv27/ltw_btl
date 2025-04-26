package com.dainv.ptit.mvc.model;

import com.dainv.ptit.mvc.entity.Category;
import com.dainv.ptit.mvc.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewPost {
    private String title;
    private String summary;
    private String content;
    private String thumbnailUrl;
    private User author;
    private Category category;
}
