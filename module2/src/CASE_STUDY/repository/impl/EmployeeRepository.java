package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.models.Person.Employee;
import CASE_STUDY.repository.IEmployeeRepository;

import java.util.*;


public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> listEmployee=new ArrayList<>();
    @Override
    public void displayEmployees() {
        System.out.println("Danh sách nhân viên trong công ty là:");
        int i=1;
        System.out.printf("%-7s%-12s%-25s%-12s%-12s%-12s%-12s%-20s%-12s%-12s%s","STT","Mã KH",
                "Họ tên","Ngày sinh","Giới tính","CMND","SĐT","Email","Trình độ","Vị trí","Lương\n");
        for (Employee employee:listEmployee){
            System.out.printf("%-7s%-12s%-25s%-12s%-12s%-12s%-12s%-20s%-12s%-12s%s",i,employee.getCodeOfPerson(),
                    employee.getName(),employee.getDateOfBirth(),employee.getGender(),employee.getId(),
                    employee.getTel(),employee.getEmail(),employee.getLevel(),employee.getPosition(),
                    employee.getSalary());
            System.out.println();
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
    }
    public static int checkId(String id) {
        int index=-1;
        for (int i=0;i<listEmployee.size();i++){
            if(listEmployee.get(i).getCodeOfPerson().equals(id)){
                return i;
            }
        }
        return index;
    }

    @Override
    public void editEmployee(int id, Employee employee1) {
                listEmployee.remove(id);
                listEmployee.add(id, employee1);
        System.out.println("Đã chỉnh sửa thông tin nhân viên");
    }
}
