package CASE_STUDY.utils.Comparator;

import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.models.Person.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList <T>  {

    public void sortCodeOfPersonCustomer(List<Customer> customerList) {
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getCodeOfPerson().compareTo(o2.getCodeOfPerson());
            }

        });
    }
}
