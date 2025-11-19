package com.ss.ch.dao.impl;

import com.ss.ch.dao.CommentDao;
import com.ss.ch.domain.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    private final SessionFactory sessionFactory;

    public CommentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Comment entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Comment entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Comment entity) {
        getSession().delete(entity);
    }

    @Override
    public Comment getById(int id) {
        return getSession().get(Comment.class, id);
    }

    @Override
    public List<Comment> getAll() {
        return getSession()
                .createQuery("FROM Comment", Comment.class)
                .getResultList();
    }
}