package com.service.employee.service;

import com.service.employee.beans.dto.EmployeeDTO;
import com.service.employee.beans.entity.Address;
import com.service.employee.beans.entity.Employee;
import com.service.employee.repo.EmployeeRepository;
import com.service.employee.util.EmployeeServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;

@Component
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;  //Class under test

    @Mock
    private EmployeeRepository employeeRepository;  //Mocked object injected automatically in Employee Service


    @Test
    public void testSave() {
        Employee employee = new Employee(1L, "Employee", Collections.singleton(new Address(1L, "area", "city", "pincode")));
        EmployeeDTO expectedResponse = new EmployeeDTO(null, employee, EmployeeServiceConstants.MSG_EMP_SAVED, EmployeeServiceConstants.STATUS_SUCCESS);

        Mockito.when(employeeRepository.save(employee)).thenReturn(employee); //Mock behavior of Save
        EmployeeDTO actualResponse = employeeService.save(employee); //calling method under test
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testSaveForException() {
        Employee employee = new Employee(1L, "Employee", Collections.singleton(new Address(1L, "area", "city", "pincode")));
        EmployeeDTO expectedResponse = new EmployeeDTO(null, null, EmployeeServiceConstants.MSG_EMP_SAVE_FAILED, EmployeeServiceConstants.STATUS_FAIL);

        Mockito.when(employeeRepository.save(employee)).thenReturn(null); //Mock behaior of Save
        EmployeeDTO actualResponse = employeeService.save(employee); //calling method under test
        Assert.assertEquals(expectedResponse, actualResponse);
    }


    @Test
    public void testFindEmployeeById() {
        Employee employee = new Employee(1L, "Employee", Collections.singleton(new Address(1L, "area", "city", "pincode")));
        EmployeeDTO expectedResponse = new EmployeeDTO(null, employee, EmployeeServiceConstants.MSG_EMP_FOUND, EmployeeServiceConstants.STATUS_SUCCESS);

        Mockito.when(employeeRepository.findOne(1L)).thenReturn(employee); //Mock behavior of find
        EmployeeDTO actualResponse = employeeService.findEmployeeById(1L); //calling method under test
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testFindfindAllEmployees() {
        Employee employee = new Employee(1L, "Employee", Collections.singleton(new Address(1L, "area", "city", "pincode")));
        List<Employee> employees = Collections.singletonList(employee);
        EmployeeDTO expectedResponse = new EmployeeDTO(employees, null, EmployeeServiceConstants.MSG_EMP_LIST, EmployeeServiceConstants.STATUS_SUCCESS);

        Mockito.when(employeeRepository.findAll()).thenReturn(employees); //Mock behavior of findall
        EmployeeDTO actualResponse = employeeService.findAllEmployees(); //calling method under test
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee(1L, "Employee", Collections.singleton(new Address(1L, "area", "city", "pincode")));
        EmployeeDTO expectedResponse = new EmployeeDTO(null, employee, EmployeeServiceConstants.MSG_EMP_UPDATED, EmployeeServiceConstants.STATUS_SUCCESS);

        Mockito.when(employeeRepository.exists(1L)).thenReturn(true);//Mock behavior of  exists
        Mockito.when(employeeRepository.findOne(1L)).thenReturn(employee); //Mock behavior of find
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee); //Mock behavior of Save

        EmployeeDTO actualResponse = employeeService.updateEmployee(1L, employee); //calling method under test
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee(1L, "Employee", Collections.singleton(new Address(1L, "area", "city", "pincode")));
        EmployeeDTO expectedResponse = new EmployeeDTO(null, employee, EmployeeServiceConstants.MSG_EMP_DELETED, EmployeeServiceConstants.STATUS_SUCCESS);

        Mockito.when(employeeRepository.exists(1L)).thenReturn(true); //Mock behavior of  exists
        Mockito.when(employeeRepository.findOne(1L)).thenReturn(employee); //Mock behavior of find
        employeeRepository.delete(1L);
        Mockito.verify(employeeRepository, times(1)).delete(1L); //Mock behavior of  delete verify

        EmployeeDTO actualResponse = employeeService.deleteEmployeeById(1L); //calling method under test
        Assert.assertEquals(expectedResponse, actualResponse);

    }

}
