package com.service.employee.util;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Employee;

import java.util.List;

public class EmployeeServiceUtil {

    private EmployeeServiceUtil() {
    }

    public static EmployeeDTO createResponseDto(Employee employee, String message, String status) {
        return EmployeeDTO.builder().employee(employee).message(message).status(status).build();
    }

    public static EmployeeDTO createResponseDto(List<Employee> employees, String message, String status) {
        return EmployeeDTO.builder().employees(employees).message(message).status(status).build();
    }
}
