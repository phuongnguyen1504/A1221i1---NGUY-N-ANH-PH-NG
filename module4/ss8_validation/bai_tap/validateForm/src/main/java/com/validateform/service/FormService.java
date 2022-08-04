package com.validateform.service;

import com.validateform.model.User;
import com.validateform.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService{
    @Autowired
    FormRepository formRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(User user) {
        formRepository.save(user);
    }

    @Override
    public void delete(int id) {

    }
}
