package com.ss.ch.dao.impl;

import com.ss.ch.dao.UserDao;
import com.ss.ch.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
