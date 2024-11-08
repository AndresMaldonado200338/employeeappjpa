package edu.uptc.swii.employeeappjpa.service;

import edu.uptc.swii.employeeappjpa.domain.Employee;
import edu.uptc.swii.employeeappjpa.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> buscarEmpleados() {
        return employeeRepository.findAll();
    }

    public Employee buscarEmpleadoPorId(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee guardarEmpleado(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean eliminarEmpleado(Integer id) {
        Optional<Employee> empleado = employeeRepository.findById(id);
        if (empleado.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
