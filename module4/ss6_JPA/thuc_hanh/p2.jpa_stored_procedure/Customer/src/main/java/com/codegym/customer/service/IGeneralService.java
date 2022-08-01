package com.codegym.customer.service;

import com.codegym.customer.model.Customer;

import java.util.List;

public interface IGeneralService <T>{
    List<Customer> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);

}
