package com.customer.service;

import com.customer.model.Customer;

import java.util.Optional;

public interface ICustomerService  {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer t);
    void remove(Long id);

}
