package com.demo.repository;

import com.demo.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {

    private Map<Integer, Employee> storage;

    public EmployeeRepository() {
    }

    public EmployeeRepository(Map<Integer, Employee> storage) {
        this.storage = storage;
    }

    public List<Employee> findAllEmployees() {
        return new ArrayList<Employee>(storage.values());
    }

    public Employee findById(Integer id) {
        return storage.get(id);
    }

    public void save(Employee employee) {
        storage.put(employee.getId(), employee);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }
}
