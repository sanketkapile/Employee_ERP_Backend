package com.emp.service.impl;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;


    public EmployeeServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = new BCryptPasswordEncoder(); // encode here
    }

    @Override
    public Employee save(Employee employee) {
        String encodePassword = passwordEncoder.encode(employee.getEmpPassword());
        employee.setEmpPassword(encodePassword);
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        employee.setEmployed(true);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee findByEmpId(String employeeId) {
        return employeeRepository.findByEmpId(employeeId);
    }

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        for (Employee employee : employees) {
            String encodePassword = passwordEncoder.encode(employee.getEmpPassword());
            employee.setEmpPassword(encodePassword);
            employee.setCreatedAt(LocalDateTime.now());
            employee.setUpdatedAt(LocalDateTime.now());
            employee.setEmployed(true);
        }
        return employeeRepository.saveAll(employees);
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
    public Employee updateEmployeeDepartmentById(String id, String department) {
        Employee employee = employeeRepository.findByEmpId(id);
        employee.setDepartment(department);
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeSalaryById(String id, Double incrementSalary) {
        Employee employee = employeeRepository.findByEmpId(id);
        if (incrementSalary <= 0) {
            throw new RuntimeException("Salary cannot be negative");
        }
        else {
            Double updatedSalary = (employee.getEmpSalary() * incrementSalary)/100;
            employee.setEmpSalary(employee.getEmpSalary() + updatedSalary);
            employee.setUpdatedAt(LocalDateTime.now());
            return employeeRepository.save(employee);
        }
    }

    @Override
    public Employee updateEmployeeRoleById(String id, String role) {
        Employee employee = employeeRepository.findByEmpId(id);
        employee.setEmpRole(role);
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }
}
