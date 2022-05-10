package FuramaCaseStudy.controller;

import CASE_STUDY.services.employee.impl.EmployeeService;
import FuramaCaseStudy.model.Employee;
import FuramaCaseStudy.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService= new EmployeeServiceImpl();

    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    public void save(Employee employee){
        employeeService.save(employee);
    }
}
