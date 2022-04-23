package CASE_STUDY.controllers;

import CASE_STUDY.models.Person.Employee;
import CASE_STUDY.services.employee.IEmployeeService;
import CASE_STUDY.services.employee.impl.EmployeeService;

public class EmployeeController {
    private static EmployeeService employeeService=new EmployeeService();
    public void displayEmployees() {
        employeeService.displayEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);

    }

    public void editEmployee(int id, Employee employee1) {
        employeeService.editEmployee(id,employee1);
    }
}
