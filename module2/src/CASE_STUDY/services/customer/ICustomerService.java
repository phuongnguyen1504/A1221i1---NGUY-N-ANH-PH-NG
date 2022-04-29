package CASE_STUDY.services.customer;

import CASE_STUDY.models.Person.Customer;

import java.util.List;

public interface ICustomerService extends BasicService<Customer> {

    @Override
    List<Customer> getAll();
}
