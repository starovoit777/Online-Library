package com.ss.ch.dao.impl;

import com.ss.ch.dao.AuthorDao;
import com.ss.ch.domain.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    private final SessionFactory sessionFactory;

    public AuthorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Author entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Author entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Author entity) {
        getSession().delete(entity);
    }

    @Override
    public Author getById(int id) {
        return getSession().get(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return getSession()
                .createQuery("FROM Author", Author.class)
                .getResultList();
    }
}