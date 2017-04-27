package com.ss.ch.service.impl;

import com.ss.ch.dao.BookDao;
import com.ss.ch.domain.Book;
import com.ss.ch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public void save(Book entity) {
        bookDao.save(entity);
    }

    public void update(Book entity) {
        bookDao.update(entity);
    }

    public void delete(Book entity) {
        bookDao.delete(entity);
    }

    public Book getById(int id) {
        return bookDao.getById(id);
    }
}
