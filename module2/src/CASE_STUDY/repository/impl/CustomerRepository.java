package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.repository.ICustomerRepository;
import CASE_STUDY.utils.ConstanUtil;
import CASE_STUDY.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    private static ReadAndWrite readAndWrite = new ReadAndWrite();
    private static int numberOfCustomer;

    public static void displayBooking() {
        displaylistCustomers();
    }

    public static int checkId(String id) {
        int index = -1;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCodeOfPerson().equals(id)) {
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
        int i = 1;
        System.out.printf("%-7s%-12s%-25s%-12s%-12s%-12s%-12s%-20s%-12s%s", "STT", "Mã KH",
                "Họ tên", "Ngày sinh", "Giới tính", "CMND", "SĐT", "Email", "Loại KH", "Địa chỉ\n");
        for (Customer customer : customerList) {
            System.out.printf("%-7s%-12s%-25s%-12s%-12s%-12s%-12s%-20s%-12s%s", i, customer.getCodeOfPerson(),
                    customer.getName(), customer.getDateOfBirth(), customer.getGender(), customer.getId(),
                    customer.getTel(), customer.getEmail(), customer.getTypeCustomer(), customer.getAddress());
            System.out.println();
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        readAndWrite.writeFile(customerList, ConstanUtil.PATH.CUSTOMER, true);
        customerList.clear();
        numberOfCustomer++;
    }

    @Override
    public void editCustomer(int index, Customer editCustomer) {
        customerList.remove(index);
        customerList.add(index, editCustomer);
        System.out.println("Đã chỉnh sửa thông tin khách hàng");
    }

    @Override
    public List<Customer> getAll(){
        List <String> stringList = readAndWrite.readFile(ConstanUtil.PATH.CUSTOMER);
        String list = "";
        System.out.println(customerList);
//        for (int i = 0; i < customerList.size(); i++) {
//
//        }
      return customerList;
    }
}
