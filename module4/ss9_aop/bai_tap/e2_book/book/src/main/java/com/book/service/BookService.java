package com.book.service;

import com.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Optional<Book> findById(Long id);
}
