package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.repository.ICustomerRepository;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList=new LinkedList<>();
    private static int numberOfCustomer;
    @Override
    public void displayCustomers() {
        int i=1;
        System.out.printf("%-12s%-12s%-12s%-12s%s","STT","CMND","Họ tên","Tuổi","Giới tính\n");
        for (Customer customer:customerList){
            System.out.printf("%-12s%-12s%-12s%-12s%s",i,customer.getId(),customer.getName(),customer.getAge(),customer.getGender());
            System.out.println();
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        numberOfCustomer++;
    }

    @Override
    public void editCustomer(int id, Customer editCustomer) {
        boolean isFind=false;
        for(int i=0;i<numberOfCustomer;i++){
            if (customerList.get(i).getId()==id){
                customerList.remove(i);
                customerList.add(i,editCustomer);
                System.out.println("Đã chỉnh sửa thông tin khách hàng");
                isFind=true;
                break;
            }
        }
        if (!isFind){
            System.out.println("Không tìm thấy phần tử cần sửa");
        }
    }
}
