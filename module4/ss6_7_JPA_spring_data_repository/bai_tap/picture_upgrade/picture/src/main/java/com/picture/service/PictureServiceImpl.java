package com.picture.service;

import com.picture.model.Feedback;
import com.picture.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private IPictureRepository repository;

    @Override
    public Page<Feedback> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Feedback song) {
        repository.save(song);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void like(int id) {
        Feedback feedback=repository.findById(id).get();
        feedback.setLikeButton(feedback.getLikeButton()+1);
        repository.save(feedback);
    }
}
