package com.picture.service;

import com.picture.model.Feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IPictureService {
    Page<Feedback> findAll(Pageable pageable);


    void save(Feedback song);

    void delete(int id);

    void like(int id);
}
