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
    public EmployeeDTO getServiceStatus() {
        log.debug("Checking status of employee service..");
        return new EmployeeDTO(null, "Service is up..!!", "success");
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        log.debug("Getting Employee details for employee id : {}", id);
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/")
    public EmployeeDTO getAllEmployees() {
        log.debug("getting list of employees..");
        return employeeService.findAllEmloyees();
    }

    @PostMapping("/")
    public EmployeeDTO createEmployee(@RequestBody Employee employee) {
        log.debug("creating new employee : {}", employee);
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        log.debug("updating employee with id : {}", id);
        return employeeService.update(id, employee);
    }
}
