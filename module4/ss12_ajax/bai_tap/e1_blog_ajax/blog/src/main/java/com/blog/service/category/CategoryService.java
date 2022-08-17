package com.blog.service.category;

import com.blog.model.Category;
import com.blog.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

}
