package com.blog.service.category;

import com.blog.model.Category;
import com.blog.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Integer category_id) {
        return categoryRepository.findById(category_id);
    }
}
