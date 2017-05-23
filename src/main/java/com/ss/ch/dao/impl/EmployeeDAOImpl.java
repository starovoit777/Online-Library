package com.ss.ch.dao.impl;


import com.ss.ch.dao.EmployeeDAO;
import com.ss.ch.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {

    public EmployeeDAOImpl(SessionFactory sessionfactory){
        setSessionFactory(sessionfactory);
    }

    @Override
    public int createEmployee(Employee emp) {
        getHibernateTemplate().persist(emp);
        return emp.getId();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return getHibernateTemplate().get(Employee.class, id);
    }

    @Override
    public void save(Employee entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Employee entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Employee entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public Employee getById(int id) {
        return getHibernateTemplate().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}
