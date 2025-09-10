package com.emp.service;

import com.emp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee save(Employee employee);
    //Employee findByEmpId(Integer empId);
    List<Employee> findAll();
    List<Employee> findByEmployeeDepartment(String employeeDepartment);
    List<Employee> findByEmployeeName(String employeeName);
    List<Employee> findByEmployeeEmail(String employeeEmail);
    List<Employee> findByPhoneNumber(Long employeePhoneNumber);
    Employee updateEmployeeDepartmentById(Integer id, String department);
    Employee updateEmployeeSalaryById(Integer id, Double salary);
    Employee updateEmployeeRoleById(Integer id, String role);
}
