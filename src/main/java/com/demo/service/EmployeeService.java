package com.demo.service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> listAllEmployees() {
        System.out.println("List of employees: ");
        return repository.findAllEmployees();
    }

    public Employee searchEmployee(Integer id) {
        System.out.println("Searching employee with id: " + id);
        return repository.findById(id);
    }

    public void addNewEmployee(Employee employee) {
        System.out.println("Adding new employee: " + employee);
        repository.save(employee);
    }

    public void deleteEmployeeById(int id) {
        System.out.println("Deleting employee with id: " + id);
        repository.deleteById(id);
    }
}
