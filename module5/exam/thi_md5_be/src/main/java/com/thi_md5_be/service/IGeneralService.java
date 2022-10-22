package com.thi_md5_be.service;

import java.util.List;

public interface IGeneralService <T>{
    List<T> findAll();

    void save(T t);
}
