package CASE_STUDY.repository.impl;

import CASE_STUDY.models.Person.Employee;
import CASE_STUDY.repository.IEmployeeRepository;

import java.util.*;


public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> listEmployee=new ArrayList<>();
    private static int numberOfEmployee;
    @Override
    public void displayEmployees() {
        System.out.println("Danh sách nhân viên trong công ty là:");
        System.out.printf("%-12s%-12s%-20s%-12s%s","STT","CMND","Họ tên","Ngáy sinh","Giới tính\n");
        /*for(int i=0;i<listEmployee.size();i++){
            Employee getEmployee=listEmployee.getClass();
            System.out.printf("%-12s%-12s%-20s%-12s%s",(i+1),getEmployee.getId(),getEmployee.getName(),getEmployee.getDateOfBirth(),getEmployee.getGender());
            System.out.println();
        }*/
        int i=0;
        for (Employee element:listEmployee){
            System.out.printf("%-12s%-12s%-20s%-12s%s",(i+1),element.getId(),element.getName(),element.getDateOfBirth(),element.getGender());
            System.out.println();
            i++;
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
    }


    @Override
    public void editEmployee(int id, Employee employee1) {
        boolean isFind = false;
        int index;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId() == id) {
                index = i;
                listEmployee.remove(index);
                listEmployee.add(index, employee1);
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            System.out.println("Không tìm thấy id cần tìm");
        }
    }
}
