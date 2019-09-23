package com.service.employee.service;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Employee;
import com.service.employee.util.EmployeeServiceConstants;
import com.service.employee.util.EmployeeServiceUtil;
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
        String responseMessage = "Saved successfully..!!";
        String status = EmployeeServiceConstants.STATUS_SUCCESS;
        Employee savedEmployee = new Employee();
        try {
            savedEmployee = employeeRepository.save(employee);
        } catch (Exception e) {
            responseMessage = "Saved failed..!!";
            status = EmployeeServiceConstants.STATUS_FAIL;
        }
        return EmployeeServiceUtil.createResponseDto(savedEmployee, responseMessage, status);
    }

    public EmployeeDTO findAllEmloyees() {
        log.debug("getting list of all employees..");
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeServiceUtil.createSuccessResponseDto(employees, "List of employees..!!");
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
        return new EmployeeDTO(Collections.singletonList(updatedEmployee), "Updated successfully..!!", EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public EmployeeDTO findEmployeeById(Long id) {
        log.debug("searching employee with id {} ", id);
        Employee employee = employeeRepository.findOne(id);
        return new EmployeeDTO(Collections.singletonList(employee), "Employee found..!!", EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public EmployeeDTO deleteEmployeeById(Long id) {
        log.debug("deleting employee with id {} ", id);
        boolean exists = employeeRepository.exists(id);
        Employee deletedEmployee = new Employee();
        if (exists) {
            Employee employee = employeeRepository.findOne(id);
            employeeRepository.delete(id);
        }
        return new EmployeeDTO(Collections.singletonList(deletedEmployee), "Employee deleted..!!", EmployeeServiceConstants.STATUS_SUCCESS);
    }
}
