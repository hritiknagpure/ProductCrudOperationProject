package com.hritik.product.service;


import org.springframework.stereotype.Service;

import com.hritik.product.model.Category;
import com.hritik.product.repository.CategoryRepository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Page<Category> findPaginatedAndSearched(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);  // Page number starts from 0
        if (keyword != null && !keyword.isEmpty()) {
            return categoryRepository.findByNameContaining(keyword, pageable);
        }
        return categoryRepository.findAll(pageable);
    }
}
