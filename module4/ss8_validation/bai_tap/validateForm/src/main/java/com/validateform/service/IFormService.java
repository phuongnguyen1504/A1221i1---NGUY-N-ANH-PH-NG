package com.validateform.service;

import com.validateform.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFormService {
    Page<User> findAll(Pageable pageable);

    void save(User user);

    void delete(int id);
}
