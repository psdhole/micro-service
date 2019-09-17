package com.service.employee.controller;

import com.service.employee.beans.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeServiceController {
    private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>() {
        private static final long serialVersionUID = -3970206781360313502L;
        {
            put(111, new Employee(111, "Employee1"));
            put(222, new Employee(222, "Employee2"));
            put(333, new Employee(111, "Employee3"));
            put(444, new Employee(222, "Employee4"));
            put(555, new Employee(111, "Employee5"));
            put(666, new Employee(222, "Employee6"));
        }
    };

    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        log.debug("Getting Employee details for employee id : {}", employeeId);
        Employee employee = employeeData.get(employeeId);
        if (employee == null) {
            employee = new Employee(0, "N/A");
        }
        return employee;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployee() {
        log.debug("Getting list of employees..");
        return new ArrayList<Employee>(employeeData.values());
    }
}
