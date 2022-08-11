package com.picture.service;

import com.picture.model.Feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPictureService {
    Page<Feedback> findAll(Pageable pageable);


    void  save(Feedback song) throws Exception;

    void delete(int id);

    void like(int id);
}
