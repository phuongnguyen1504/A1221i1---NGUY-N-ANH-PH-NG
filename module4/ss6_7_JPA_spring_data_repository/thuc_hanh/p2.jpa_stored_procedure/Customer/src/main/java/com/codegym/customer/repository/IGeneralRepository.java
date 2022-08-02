package com.codegym.customer.repository;

import com.codegym.customer.model.Customer;

import java.util.List;

public interface IGeneralRepository <T>{
    List<T> findAll();
    T findById(Long id);
    void save(T t);

    void remove(Long id);
    boolean insertWithStoredProcedure(T t);

}
