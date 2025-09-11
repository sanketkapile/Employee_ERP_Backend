package com.emp.service.impl;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckPermissionImpl implements CheckPermission {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String checkPermission(Employee employee) {
        String empId = employee.getEmpId();
        String empRole = employee.getEmpRole();
        switch (empRole) {

        }
        return "";
    }

    @Override
    public String permission(Integer empId) {
        return "";
    }
}
