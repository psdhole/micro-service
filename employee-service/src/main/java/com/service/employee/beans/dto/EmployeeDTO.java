package com.service.employee.beans.dto;

import com.service.employee.beans.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Builder
@Component
@AllArgsConstructor
public class EmployeeDTO {
    private List<Employee> employees;
    private Employee employee;
    private String message;
    private String status;
}
