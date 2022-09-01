package com.furama.service;

import java.util.List;
import java.util.Set;

public interface IGeneralService <T> {
    List<T> findAll();

    void save(T t);
}
