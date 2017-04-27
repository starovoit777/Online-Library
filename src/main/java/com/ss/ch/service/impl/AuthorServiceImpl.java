package com.ss.ch.service.impl;

import com.ss.ch.dao.AuthorDao;
import com.ss.ch.domain.Author;
import com.ss.ch.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public void save(Author entity) {
        authorDao.save(entity);
    }

    public void update(Author entity) {
        authorDao.update(entity);
    }

    public void delete(Author entity) {
        authorDao.delete(entity);
    }

    public Author getById(int id) {
        return  authorDao.getById(id);
    }
}
