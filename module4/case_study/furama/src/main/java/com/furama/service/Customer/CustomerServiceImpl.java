package com.furama.service.Customer;

import com.furama.model.Customer.Customer;
import com.furama.repository.Customer.CustomerRepository;
import com.furama.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Set;
@Service
public class CustomerServiceImpl implements IGeneralService<Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
    public void delete(int id){
        customerRepository.deleteById(id);
    }

    public Page<Customer> find(String q, Pageable pageable) {
        if(!StringUtils.isEmpty(q)){
            String[] tmp=q.split(":");
            String searchBy=tmp[0];
            String searchVal=tmp[1];
            switch (searchBy){
                case "name":
                    return customerRepository.findByNameContaining(searchVal,pageable);
                case "birthday":
                    return customerRepository.findByBirthdayContaining(searchVal,pageable);
                case "gender":
                    return customerRepository.findByGender(searchVal,pageable);
                case "card":
                    return customerRepository.findById_CardContaining("%".concat(searchVal).concat("%"),pageable);
                case "phone":
                    return customerRepository.findByPhoneContaining(searchVal,pageable);
                case "mail":
                    return customerRepository.findByMailContaining(searchVal,pageable);
                case "address":
                    return customerRepository.findByAddressContaining(searchVal,pageable);
                default:
                    Page<Customer> customers= customerRepository.findAllByValue("%".concat(searchVal).concat("%"), pageable);
                    return customers;
            }
        }
        return customerRepository.findAll(pageable);
    }
}
