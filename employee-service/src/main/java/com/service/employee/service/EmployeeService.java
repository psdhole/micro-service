package com.service.employee.service;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO save(Employee employee) {
        log.debug("adding new employee : {}", employee);
        employeeRepository.save(employee);
        return new EmployeeDTO(Collections.singletonList(employee), "Saved successfully..!!", "success");
    }

    public EmployeeDTO findAllEmloyees() {
        log.debug("getting list of all employees..");
        List<Employee> employees = employeeRepository.findAll();
        return new EmployeeDTO(employees, "List of employees..!!", "success");
    }

    public EmployeeDTO update(Long id, Employee employee) {
        log.debug("updating employee with id {} ", id);
        boolean exists = employeeRepository.exists(id);
        Employee updatedEmployee = new Employee();
        if (exists) {
            Employee employeeToUpdate = employeeRepository.findOne(id);
            employeeToUpdate.setAddress(employee.getAddress());
            employeeToUpdate.setName(employee.getName());
            updatedEmployee = employeeRepository.save(employeeToUpdate);
        }
        return new EmployeeDTO(Collections.singletonList(updatedEmployee), "Updated successfully..!!", "success");
    }

    public EmployeeDTO findEmployeeById(Long id) {
        log.debug("searching employee with id {} ", id);
        Employee employee = employeeRepository.findOne(id);
        return new EmployeeDTO(Collections.singletonList(employee), "Employee found..!!", "success");
    }

    public EmployeeDTO deleteEmployeeById(Long id) {
        log.debug("deleting employee with id {} ", id);
        boolean exists = employeeRepository.exists(id);
        Employee deletedEmployee = new Employee();
        if (exists) {
            Employee employee = employeeRepository.findOne(id);
            employeeRepository.delete(id);
        }
        return new EmployeeDTO(Collections.singletonList(deletedEmployee), "Employee deleted..!!", "success");
    }
}
