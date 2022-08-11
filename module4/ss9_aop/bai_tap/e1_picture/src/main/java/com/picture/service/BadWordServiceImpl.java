package com.picture.service;

import com.picture.model.BadWord;
import com.picture.repository.BadWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadWordServiceImpl {
    @Autowired
    private BadWordRepository badWordRepository;

    public List<BadWord> findAll() {
        return badWordRepository.findAll();
    }

    public List<String> findListName() {
        return badWordRepository.findListName();
    }
}
