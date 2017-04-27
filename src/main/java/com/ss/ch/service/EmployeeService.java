package com.ss.ch.service;


import com.ss.ch.domain.Employee;

public interface EmployeeService {
    int createEmployee(Employee emp);
    Employee getEmployeeById(int id);
}
