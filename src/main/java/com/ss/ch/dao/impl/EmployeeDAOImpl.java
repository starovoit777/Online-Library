package com.ss.ch.dao.impl;

import com.ss.ch.dao.EmployeeDAO;
import com.ss.ch.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int createEmployee(Employee emp) {
        getSession().persist(emp);
        return emp.getId();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public void save(Employee entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Employee entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Employee entity) {
        getSession().delete(entity);
    }

    @Override
    public Employee getById(int id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        return getSession()
                .createQuery("FROM Employee", Employee.class)
                .getResultList();
    }
}