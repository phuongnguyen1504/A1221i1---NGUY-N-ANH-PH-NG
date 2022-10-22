package com.example.service;

import java.util.List;

public interface IGeneralService <T>{
    List<T> findAll();

    void save(T t);
}
