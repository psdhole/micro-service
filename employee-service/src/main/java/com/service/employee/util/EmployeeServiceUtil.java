package com.service.employee.util;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeServiceUtil {

    private EmployeeServiceUtil() {
    }

    public static EmployeeDTO createSuccessResponseDto(Employee employee, String successMessage) {
        return new EmployeeDTO(Collections.singletonList(employee), successMessage, EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public static EmployeeDTO createSuccessResponseDto(List<Employee> employees, String successMessage) {
        return new EmployeeDTO(employees, successMessage, EmployeeServiceConstants.STATUS_SUCCESS);
    }

    public static EmployeeDTO createResponseDto(Employee savedEmployee, String responseMessage, String status) {
        return new EmployeeDTO(Collections.singletonList(savedEmployee), responseMessage, status);
    }
}
