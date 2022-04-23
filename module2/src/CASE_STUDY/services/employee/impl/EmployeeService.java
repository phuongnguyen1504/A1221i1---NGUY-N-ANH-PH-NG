package CASE_STUDY.services.employee.impl;

import CASE_STUDY.models.Person.Employee;
import CASE_STUDY.repository.IEmployeeRepository;
import CASE_STUDY.repository.impl.EmployeeRepository;
import CASE_STUDY.services.employee.IEmployeeService;

public class EmployeeService implements IEmployeeService {
    private static IEmployeeRepository employeeRepository=new EmployeeRepository();
    public void displayEmployees() {
        employeeRepository.displayEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public void editEmployee(int id, Employee employee1) {
        employeeRepository.editEmployee(id,employee1);
    }
}
