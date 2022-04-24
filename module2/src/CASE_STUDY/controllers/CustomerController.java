package CASE_STUDY.controllers;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.services.customer.impl.CustomerService;

public class CustomerController {
    private static CustomerService customerService=new CustomerService();
    public void displayCustomers() {
        customerService.displayCustomers();
    }

    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    public void editCustomer(int id, Customer editCustomer) {
        customerService.editCustomer(id,editCustomer);
    }
}
