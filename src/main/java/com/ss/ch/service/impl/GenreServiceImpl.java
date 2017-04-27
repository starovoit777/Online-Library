package com.ss.ch.service.impl;

import com.ss.ch.dao.GenreDao;
import com.ss.ch.domain.Genre;
import com.ss.ch.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    public void save(Genre entity) {
        genreDao.save(entity);
    }


    public void update(Genre entity) {
        genreDao.update(entity);
    }

    public void delete(Genre entity) {
        genreDao.delete(entity);
    }

    public Genre getById(int id) {
        return  genreDao.getById(id);
    }
}
