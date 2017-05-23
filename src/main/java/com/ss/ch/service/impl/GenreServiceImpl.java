package com.ss.ch.service.impl;

import com.ss.ch.dao.GenreDao;
import com.ss.ch.domain.Genre;
import com.ss.ch.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public void save(Genre entity) {
        genreDao.save(entity);
    }

    @Override
    public void update(Genre entity) {
        genreDao.update(entity);
    }

    @Override
    public void delete(Genre entity) {
        genreDao.delete(entity);
    }

    @Override
    public Genre getById(int id) {
        return genreDao.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
