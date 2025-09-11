package com.emp.service;

import com.emp.entity.Employee;

public interface CheckPermission {

    String checkPermission(Employee employee);
    String permission(Integer empId);

}
