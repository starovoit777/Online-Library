package com.ss.ch.dao.impl;

import com.ss.ch.dao.GenreDao;
import com.ss.ch.domain.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenreDaoImpl implements GenreDao {

    private final SessionFactory sessionFactory;

    public GenreDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Genre entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Genre entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Genre entity) {
        getSession().delete(entity);
    }

    @Override
    public Genre getById(int id) {
        return getSession().get(Genre.class, id);
    }

    @Override
    public List<Genre> getAll() {
        return getSession()
                .createQuery("FROM Genre", Genre.class)
                .getResultList();
    }
}