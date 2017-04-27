package com.ss.ch.dao;


import com.ss.ch.domain.Employee;

public interface EmployeeDAO extends CrudDao<Employee>{
    int createEmployee(Employee emp);
    Employee getEmployeeById(int id);




}
