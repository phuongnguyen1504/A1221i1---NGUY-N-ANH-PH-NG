package com.blog.service;

import com.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();


    void save(Blog student);


    void delete(int id);

    Optional<Blog> findById(int id);

//    List<Blog> searchByName(String keyword);
}
