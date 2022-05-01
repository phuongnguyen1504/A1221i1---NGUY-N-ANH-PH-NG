package CASE_STUDY.services.customer.impl;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.repository.ICustomerRepository;
import CASE_STUDY.repository.impl.CustomerRepository;
import CASE_STUDY.services.customer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private static ICustomerRepository customerRepository= new CustomerRepository();
    public void displayCustomers() {
        customerRepository.displayCustomers();
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public void editCustomer(String id, Customer editCustomer) {
        customerRepository.editCustomer(id,editCustomer);
    }

    @Override
    public List<Customer>getAll(){
        return customerRepository.getAll();
    }
}
