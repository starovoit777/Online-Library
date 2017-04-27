package com.ss.ch.dao.impl;

import com.ss.ch.dao.GenreDao;
import com.ss.ch.domain.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Micro on 4/24/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class GenreDaoImplTest {

    @Autowired
    private GenreDao genreDao;

    Genre genre;
    Genre genre1;

    @Before
    public void init() throws Exception {
        genre = new Genre();
        genre1 = new Genre();
        genre.setName("TestDao genre");
        genre1.setName("TestDao genre2");
    }
    @Test
    public void crud() throws Exception {
        genreDao.save(genre);
        genreDao.save(genre1);
        genre1.setName("TestDao genre update");
        genreDao.update(genre1);
        genreDao.delete(genre1);
        System.out.print(genreDao.getById(1));
    }


    @Test
    public void save() throws Exception {
        genreDao.save(genre);
        genreDao.save(genre1);

    }

    @Test
    public void update() throws Exception {
        genre1.setName("TestDao genre update");
        genreDao.update(genre1);
    }

    @Test
    public void delete() throws Exception {
        genreDao.delete(genre1);
    }

    @Test
    public void getById() throws Exception {
        System.out.print(genreDao.getById(1));
    }

}