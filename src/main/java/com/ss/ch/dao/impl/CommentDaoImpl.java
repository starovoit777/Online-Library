package com.ss.ch.dao.impl;

import com.ss.ch.dao.CommentDao;
import com.ss.ch.domain.Comment;
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
public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {

    public CommentDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public void save(Comment entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Comment entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Comment entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public Comment getById(int id) {
        return getHibernateTemplate().get(Comment.class, id);
    }
}
