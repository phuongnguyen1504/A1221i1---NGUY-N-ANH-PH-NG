package com.validateform.repository;

import com.validateform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<User,Integer> {
}
