package vn.codegym.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.backend.model.Employee;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee where email = ?1", nativeQuery = true)
    Optional<Employee> findByEmail(String email);
}
