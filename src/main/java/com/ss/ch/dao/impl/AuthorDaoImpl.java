package com.ss.ch.dao.impl;

import com.ss.ch.dao.AuthorDao;
import com.ss.ch.domain.Author;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Micro on 4/24/2017.
 */

@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class AuthorDaoImpl extends HibernateDaoSupport implements AuthorDao {

    public AuthorDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }


    @Override
    public void save(Author entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Author entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Author entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public Author getById(int id) {
        return getHibernateTemplate().get(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors;
        authors = (List<Author>) this.getHibernateTemplate().find("from Author");
        return authors;
    }
}
