package com.demo;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppLauncher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService testService = (EmployeeService) context.getBean("employeeService");

        // find all employee
        System.out.println("\n----------:FIND all employees:------------\n");
        List<Employee> list = testService.listAllEmployees();
        System.out.println(list);

        // ADD a new employee
        System.out.println("\n----------:ADD a new employee:------------\n");
        Employee employee = new Employee();
        employee.setId(103);
        employee.setName("Subha");
        employee.setSalary(2);

        testService.addNewEmployee(employee);
        System.out.println(testService.listAllEmployees());

        // DELETE an employee by ID
        System.out.println("\n----------:DELETE an employee by ID:------------\n");
        int id = 100;
        testService.deleteEmployeeById(id);
        System.out.println(testService.listAllEmployees());

        // SEARCH an employee by ID
        System.out.println("\n----------:SEARCH an employee by ID:------------\n");
        id = 101;
        Employee e = testService.searchEmployee(id);
        if (e != null)
            System.out.println("Employee details: " + e);
        else
            System.out.println("Employee with id " + id + " not found");

        id = 100;
        Employee e1 = testService.searchEmployee(id);
        if (e1 != null)
            System.out.println("Employee details: " + e1);
        else
            System.out.println("Employee with id " + id + " not found");

        context.close();
    }
}
