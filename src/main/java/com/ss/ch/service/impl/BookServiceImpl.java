package com.ss.ch.service.impl;

import com.ss.ch.dao.BookDao;
import com.ss.ch.domain.Book;
import com.ss.ch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book entity) {
        bookDao.save(entity);
    }

    @Override
    public void update(Book entity) {
        bookDao.update(entity);
    }

    @Override
    public void delete(Book entity) {
        bookDao.delete(entity);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
