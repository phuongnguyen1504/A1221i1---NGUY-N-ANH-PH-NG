package CASE_STUDY.repository;

import CASE_STUDY.models.Person.Employee;

public interface IEmployeeRepository {
    void displayEmployees();

    void addEmployee(Employee employee);

    void editEmployee(int id,Employee employee1);
}
