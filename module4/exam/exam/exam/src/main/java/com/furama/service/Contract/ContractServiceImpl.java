package com.furama.service.Contract;

import com.furama.model.Contract.Contract;
import com.furama.repository.Contract.ContractRepository;
import com.furama.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements IGeneralService<Contract> {
    @Autowired
    private ContractRepository customerRepository;

    @Override
    public List<Contract> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Contract customer) {
        customerRepository.save(customer);
    }
    public void delete(String id){
//        Contract customer=customerRepository.findById(id).get();
//        customer.setDelete(true);
//        customerRepository.save(customer);
        customerRepository.deleteById(id);
    }

//

    public Optional<Contract> findById(String id) {
        return customerRepository.findById(id);
    }
}
