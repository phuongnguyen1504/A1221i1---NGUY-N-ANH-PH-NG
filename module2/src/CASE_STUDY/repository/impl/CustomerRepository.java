package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.models.Person.Person;
import CASE_STUDY.repository.ICustomerRepository;
import CASE_STUDY.utils.Comparator.SortList;
import CASE_STUDY.utils.ConstanUtil;
import CASE_STUDY.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    private static List<String> addList=new ArrayList<>();
    private static ReadAndWrite readAndWrite = new ReadAndWrite();
    private static SortList<Customer> sortList=new SortList<>();


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

    private void displaylistCustomers() {
        customerList=getAll();
        /*customerList.stream().sorted((o1, o2) -> o1.getCodeOfPerson().compareTo(o2.getCodeOfPerson()));*/
        /*Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getCodeOfPerson().compareTo(o2.getCodeOfPerson());
            }
        });*/
        sortList.sortCodeOfPersonCustomer(customerList);
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
        addList=new ArrayList<>();
        addList.add(formatInformationStudent(customer));
        readAndWrite.writeFile(addList, ConstanUtil.PATH.CUSTOMER, true);
        addList.clear();
    }

    private String formatInformationStudent(Customer customer) {
        return customer.getCodeOfPerson()+","+ customer.getName()+","+customer.getDateOfBirth()+","+customer.getGender()+","+
                customer.getId()+","+customer.getTel()+","+customer.getEmail()+","+customer.getTypeCustomer()+","+customer.getAddress();
    }

    @Override
    public void editCustomer(String customerCode, Customer editCustomer) {
        customerList=getAll();
        addList=new ArrayList<>();
        for (Customer customer:customerList){
            if (customer.getCodeOfPerson().equals(customerCode)){
                addList.add(formatInformationStudent(editCustomer));
            }
            else {
                addList.add(formatInformationStudent(customer));
            }
        }
        readAndWrite.writeFile(addList,ConstanUtil.PATH.CUSTOMER);
        System.out.println("Đã chỉnh sửa thông tin khách hàng");
    }

    @Override
    public List<Customer> getAll() {
        List<String> stringList = readAndWrite.readFile(ConstanUtil.PATH.CUSTOMER);
        customerList=new ArrayList<>();
        for(String li:stringList){
            String[] temp=li.split(",");
            customerList.add(new Customer(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4]),Integer.parseInt(temp[5]),temp[6],temp[7],temp[8]));
        }
        return customerList;
    }

}
