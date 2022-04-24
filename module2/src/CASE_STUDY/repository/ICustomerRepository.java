package CASE_STUDY.repository;

import CASE_STUDY.models.Person.Customer;

public interface ICustomerRepository {
    void displayCustomers();

    void addCustomer(Customer customer);

    void editCustomer(int id, Customer editCustomer);
}
