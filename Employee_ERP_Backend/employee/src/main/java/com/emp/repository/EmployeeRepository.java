package com.emp.repository;

import com.emp.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    Employee findByEmpId(String employeeId);
    List<Employee> findByEmpName(String empName);
    List<Employee> findByEmpEmail(String empEmail);
    List<Employee> findByEmpContactNumber(Long empContactNumber);
    List<Employee> findByDepartment(String department);

}
