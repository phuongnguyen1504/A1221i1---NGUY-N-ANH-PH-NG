package com.thi_md5_be.service;


import com.thi_md5_be.model.Category;
import com.thi_md5_be.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements IGeneralService<Category>{
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> categories;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findCategory();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
    public Optional<Category> findById(int id){
        return categoryRepository.findById(id);
    }
}
