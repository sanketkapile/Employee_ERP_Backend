package com.emp.controller;

import com.emp.entity.Employee;
import com.emp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee_erp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Save New Employee
    @PostMapping("/register")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Save Bulk Employees
    @PostMapping("/registerAll")
    public ResponseEntity<List<Employee>> registerAllEmployees(@RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = employeeService.saveAll(employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    //Find All Employee List
    @GetMapping("/users")
    public ResponseEntity<List<Employee>> displayEmployee() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //Find Employee by ID
    @GetMapping("/user/{employeeId}")
    public ResponseEntity<Employee> displayEmployeeById(@PathVariable String employeeId) {
        Employee employee = employeeService.findByEmpId(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //List all the employees in the department
    @GetMapping("/dept/{departmentName}")
    public ResponseEntity<List<Employee>> displayEmployeeByDepartment(@PathVariable String departmentName) {
        try{
            List<Employee> employeeList = employeeService.findByEmployeeDepartment(departmentName);
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //List all the employees with the same name
    @GetMapping("/employee/{firstName}/{lastName}")
    public ResponseEntity<List<Employee>> displayEmployeeByName(@PathVariable String firstName, @PathVariable String lastName) {
        try{
            String employeeName = (firstName +" " + lastName).trim();
            List<Employee> employeeList = employeeService.findByEmployeeName(employeeName.trim());
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //List all the employees with the same email id
    @GetMapping("/email/{employeeEmail}")
    public ResponseEntity<List<Employee>> displayEmployeeByEmail(@PathVariable String employeeEmail) {
        try{
            List<Employee> employeeList = employeeService.findByEmployeeEmail(employeeEmail);
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //List all the employees with the same phone number
    @GetMapping("/contact/{employeePhoneNumber}")
    public ResponseEntity<List<Employee>> displayEmployeeByContactNo(@PathVariable Long employeePhoneNumber) {
        try{
            List<Employee> employeeList = employeeService.findByPhoneNumber(employeePhoneNumber);
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Update employee salary by employee id
    @PutMapping("/update/{employeeId}/sal/{empSalary}")
    public ResponseEntity<Employee> updateEmployeeSalaryById(@PathVariable String employeeId,
                                                             @PathVariable Double empSalary) {
        try{
            Employee employee = employeeService.updateEmployeeSalaryById(employeeId,empSalary);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Update department by employee id
    @PutMapping("/update/{employeeId}/dept/{department}")
    public ResponseEntity<Employee> updateEmployeeSalaryById(@PathVariable String employeeId,
                                                             @PathVariable String department) {
        try{
            Employee employee = employeeService.updateEmployeeDepartmentById(employeeId,department);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Update an employee role by employee id
    @PutMapping("/update/{employeeId}/role/{role}")
    public ResponseEntity<Employee> updateEmployeeRoleById(@PathVariable String employeeId,
                                                             @PathVariable String role) {
        try{
            Employee employee = employeeService.updateEmployeeRoleById(employeeId,role);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
