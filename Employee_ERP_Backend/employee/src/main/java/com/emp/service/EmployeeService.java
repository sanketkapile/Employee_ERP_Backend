package com.emp.service;

import com.emp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee save(Employee employee);
    Employee findByEmpId(String employeeId);
    List<Employee> saveAll(List<Employee> employees);
    List<Employee> findAll();
    List<Employee> findByEmployeeDepartment(String employeeDepartment);
    List<Employee> findByEmployeeName(String employeeName);
    List<Employee> findByEmployeeEmail(String employeeEmail);
    List<Employee> findByPhoneNumber(Long employeePhoneNumber);
    Employee updateEmployeeDepartmentById(String id, String department);
    Employee updateEmployeeSalaryById(String id, Double incrementSalary);
    Employee updateEmployeeRoleById(String id, String role);
}
