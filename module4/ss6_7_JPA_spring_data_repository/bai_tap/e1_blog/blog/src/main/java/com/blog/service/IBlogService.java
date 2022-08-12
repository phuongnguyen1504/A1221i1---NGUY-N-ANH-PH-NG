package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();


    void save(Blog student);


    void delete(int id);

    Optional<Blog> findById(int id);

    Page<Blog> findAll(Pageable pageable);

//    List<Blog> searchByName(String keyword);
}
