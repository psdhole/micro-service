package com.service.employee.service;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Employee;
import com.service.employee.repo.EmployeeRepository;
import com.service.employee.util.EmployeeServiceConstants;
import com.service.employee.util.EmployeeServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO save(Employee employee) {
        log.debug("adding new employee : {}", employee);
        String responseMessage = EmployeeServiceConstants.MSG_EMP_SAVED;
        String status = EmployeeServiceConstants.STATUS_SUCCESS;
        Employee savedEmployee = employeeRepository.save(employee);
        if (Objects.isNull(savedEmployee)) {
            responseMessage = EmployeeServiceConstants.MSG_EMP_SAVE_FAILED;
            status = EmployeeServiceConstants.STATUS_FAIL;
        }
        return EmployeeServiceUtil.createResponseDto(savedEmployee, responseMessage, status);
    }

    public EmployeeDTO findAllEmployees() {
        log.debug("getting list of all employees..");
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeServiceUtil.createResponseDto(employees, EmployeeServiceConstants.MSG_EMP_LIST, EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public EmployeeDTO updateEmployee(Long id, Employee employee) {
        log.debug("updating employee with id {} ", id);
        boolean exists = employeeRepository.exists(id);
        Employee updatedEmployee = Employee.builder().build();
        if (exists) {
            Employee employeeToUpdate = employeeRepository.findOne(id);
            employeeToUpdate.setAddress(employee.getAddress());
            employeeToUpdate.setName(employee.getName());
            updatedEmployee = employeeRepository.save(employeeToUpdate);
        }
        return EmployeeServiceUtil.createResponseDto(updatedEmployee, EmployeeServiceConstants.MSG_EMP_UPDATED, EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public EmployeeDTO findEmployeeById(Long id) {
        log.debug("searching employee with id {} ", id);
        Employee employee = employeeRepository.findOne(id);
        return EmployeeServiceUtil.createResponseDto(employee, EmployeeServiceConstants.MSG_EMP_FOUND, EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public EmployeeDTO deleteEmployeeById(Long id) {
        log.debug("deleting employee with id {} ", id);
        boolean exists = employeeRepository.exists(id);
        Employee deletedEmployee = Employee.builder().build();
        if (exists) {
            deletedEmployee = employeeRepository.findOne(id);
            employeeRepository.delete(id);
        }
        return EmployeeServiceUtil.createResponseDto(deletedEmployee, EmployeeServiceConstants.MSG_EMP_DELETED, EmployeeServiceConstants.STATUS_SUCCESS);
    }
}
