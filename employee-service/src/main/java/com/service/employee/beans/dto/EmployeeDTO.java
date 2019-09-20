package com.service.employee.beans.dto;

import com.service.employee.beans.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private List<Employee> employees;
    private String message;
    private String status;
}
