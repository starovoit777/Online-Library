package com.ss.ch.service.impl;


import com.ss.ch.dao.EmployeeDAO;
import com.ss.ch.domain.Employee;
import com.ss.ch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public int createEmployee(Employee emp) {
        employeeDAO.createEmployee(emp);
        return emp.getId();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

}
