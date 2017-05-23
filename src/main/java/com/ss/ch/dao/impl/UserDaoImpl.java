package com.ss.ch.dao.impl;

import com.ss.ch.dao.UserDao;
import com.ss.ch.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micro on 4/24/2017.
 */

@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    public UserDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public void save(User entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(User entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(User entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public User getById(int id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        List<User> users;
        users = (List<User>) this.getHibernateTemplate().find("from User");
        return users;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users;
        users = (List<User>) this.getHibernateTemplate().find("from User");
        return users;

    }
}
