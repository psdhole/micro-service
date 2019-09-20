package com.service.employee.service;

import com.service.employee.beans.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
