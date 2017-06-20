package com.ss.ch.dao.impl;

import com.ss.ch.dao.GenreDao;
import com.ss.ch.domain.Genre;
import com.ss.ch.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class GenreDaoImpl extends HibernateDaoSupport implements GenreDao {

    public GenreDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public void save(Genre entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Genre entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Genre entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public Genre getById(int id) {
        return getHibernateTemplate().get(Genre.class, id);
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres;
        genres = (List<Genre>) this.getHibernateTemplate().find("from Genre");
        return genres;    }
}
