package CASE_STUDY.repository;

import CASE_STUDY.models.Person.Customer;

import java.util.List;

public interface ICustomerRepository {
    void displayCustomers();

    void addCustomer(Customer customer);

    void editCustomer(String id, Customer editCustomer);

    List<Customer> getAll();
}
