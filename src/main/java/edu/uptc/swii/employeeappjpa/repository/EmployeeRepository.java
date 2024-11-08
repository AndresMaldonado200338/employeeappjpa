package edu.uptc.swii.employeeappjpa.repository;

import edu.uptc.swii.employeeappjpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
