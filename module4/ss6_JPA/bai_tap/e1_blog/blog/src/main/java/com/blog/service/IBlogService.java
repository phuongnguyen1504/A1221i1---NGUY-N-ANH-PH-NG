package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();


    void save(Blog student);


    void delete(int id);

//    List<Blog> searchByName(String keyword);
}
