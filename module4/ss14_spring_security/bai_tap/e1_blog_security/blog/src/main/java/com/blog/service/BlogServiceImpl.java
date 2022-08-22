package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Blog student) {
        repository.save(student);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return  repository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByCategory(String category) {
        return repository.findAllByCategory(category);
    }

    @Override
    public List<Blog> findAllByKey(String key) {
        return repository.findAllByKey(key);
    }


//    @Override
//    public List<Blog> searchByName(String keyword) {
////        return repository.findByNameContaining(keyword);
////        return repository.findByNameContainingAndIdGreaterThan(keyword, 2);
//        return repository.searchByName(keyword);

}
