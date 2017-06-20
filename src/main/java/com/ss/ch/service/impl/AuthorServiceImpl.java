package com.ss.ch.service.impl;

import com.ss.ch.dao.AuthorDao;
import com.ss.ch.domain.Author;
import com.ss.ch.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void save(Author entity) {
        authorDao.save(entity);
    }

    @Override
    public void update(Author entity) {
        authorDao.update(entity);
    }

    @Override
    public void delete(Author entity) {
        authorDao.delete(entity);
    }

    @Override
    public Author getById(int id) {
        return authorDao.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
