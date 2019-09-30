package com.service.employee.controller;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Employee;
import com.service.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/api/v1")
@Slf4j
public class EmployeeServiceController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/status")
    public String getServiceStatus() {
        log.debug("Checking status of employee service..");
        return "success";
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        log.debug("Getting Employee details for employee id : {}", id);
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/")
    public EmployeeDTO getAllEmployees() {
        log.debug("getting list of employees..");
        return employeeService.findAllEmployees();
    }

    @PostMapping("/")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDto) {
        log.debug("creating new employee : {}", employeeDto.getEmployee());
        Employee employee = employeeDto.getEmployee();
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDto, @PathVariable Long id) {
        log.debug("updating employee with id : {}", id);
        Employee employee = employeeDto.getEmployee();
        return employeeService.updateEmployee(id, employee);
    }
}
