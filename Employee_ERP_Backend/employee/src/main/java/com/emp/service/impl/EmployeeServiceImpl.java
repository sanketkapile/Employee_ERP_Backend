package com.emp.service.impl;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        employee.setEmployed(true);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByEmpId(Integer empId) {
        Employee employee = employeeRepository.findByEmpId(empId);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByEmployeeDepartment(String departmentName) {
        return employeeRepository.findByDepartment(departmentName);
    }

    @Override
    public List<Employee> findByEmployeeName(String employeeName) {
        return employeeRepository.findByEmpName(employeeName);
    }

    @Override
    public List<Employee> findByEmployeeEmail(String email) {
        return employeeRepository.findByEmpEmail(email);
    }

    @Override
    public List<Employee> findByPhoneNumber(Long phoneNumber) {
        return employeeRepository.findByEmpContactNumber(phoneNumber);
    }

    @Override
    public Employee updateEmployeeDepartmentById(Integer id, String department) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setDepartment(department);
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeSalaryById(Integer id, Double salary) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setEmpSalary(salary);
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeRoleById(Integer id, String role) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setEmpRole(role);
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }
}
