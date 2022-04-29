package CASE_STUDY.repository;

import CASE_STUDY.models.Person.Customer;

import java.util.List;

public interface ICustomerRepository extends BasicRes<Customer>{
    void displayCustomers();

    void addCustomer(Customer customer);

    void editCustomer(int id, Customer editCustomer);

    List<Customer> getAll();
}
