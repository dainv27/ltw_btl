package com.dainv.ptit.mvc.service.impl;

import com.dainv.ptit.mvc.entity.Category;
import com.dainv.ptit.mvc.repository.CategoryRepository;
import com.dainv.ptit.mvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Integer page, Integer limit) {
        return categoryRepository.findAll(PageRequest.of(page, limit, Sort.by("createdTime").descending()));
    }
}
