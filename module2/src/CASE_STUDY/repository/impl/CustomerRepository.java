package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.repository.ICustomerRepository;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList=new LinkedList<>();
    private static int numberOfCustomer;

    public static void displayBooking() {
        displaylistCustomers();
    }

    public static int checkId(String id) {
        int index=-1;
        for (int i=0;i<customerList.size();i++){
            if(customerList.get(i).getCodeOfPerson().equals(id)){
                return i;
            }
        }
        return index;
    }

    @Override
    public void displayCustomers() {
        displaylistCustomers();
    }

    private static void displaylistCustomers() {
        int i=1;
        System.out.printf("%-7s%-12s%-25s%-12s%-12s%-12s%-12s%-20s%-12s%s","STT","Mã KH",
                "Họ tên","Ngày sinh","Giới tính","CMND","SĐT","Email","Loại KH","Địa chỉ\n");
        for (Customer customer:customerList){
            System.out.printf("%-7s%-12s%-25s%-12s%-12s%-12s%-12s%-20s%-12s%s",i,customer.getCodeOfPerson(),
                    customer.getName(),customer.getDateOfBirth(),customer.getGender(),customer.getId(),
                    customer.getTel(),customer.getEmail(),customer.getTypeCustomer(),customer.getAddress());
            System.out.println();
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        numberOfCustomer++;
    }

    @Override
    public void editCustomer(int index, Customer editCustomer) {
                customerList.remove(index);
                customerList.add(index,editCustomer);
                System.out.println("Đã chỉnh sửa thông tin khách hàng");
    }
}
