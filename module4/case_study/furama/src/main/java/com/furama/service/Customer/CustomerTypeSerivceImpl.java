package com.furama.service.Customer;

import com.furama.model.Customer.CustomerType;
import com.furama.repository.Customer.CustomerTypeRepository;
import com.furama.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerTypeSerivceImpl implements IGeneralService<CustomerType> {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }
}
