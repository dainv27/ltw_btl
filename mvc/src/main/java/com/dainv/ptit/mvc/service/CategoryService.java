package com.dainv.ptit.mvc.service;

import com.dainv.ptit.mvc.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Integer page, Integer limit);
}
