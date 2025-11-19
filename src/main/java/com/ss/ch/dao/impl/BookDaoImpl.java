package com.ss.ch.dao.impl;

import com.ss.ch.dao.BookDao;
import com.ss.ch.domain.Book;
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
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {


    public BookDaoImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }


    @Override
    public void save(Book entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Book entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Book entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public Book getById(int id) {
        return getHibernateTemplate().get(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        List<Book> books;
        books = (List<Book>) this.getHibernateTemplate().find("from Book");
        return books;
    }
}
