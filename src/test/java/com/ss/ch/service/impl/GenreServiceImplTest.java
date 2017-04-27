package com.ss.ch.service.impl;

import com.ss.ch.domain.Genre;
import com.ss.ch.service.GenreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Micro on 4/24/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring-config.xml")
public class GenreServiceImplTest {

    @Autowired
    private GenreService genreService;

    Genre genre;
    Genre genre1;

    @Before
    public void init() throws Exception {
        genre = new Genre();
        genre1 = new Genre();
        genre.setName("TestService genre");
        genre1.setName("Test genre2");
    }

    @Test
    public void crud() throws Exception {
        genreService.save(genre);
        genreService.save(genre1);
        genre1.setName("Test Service genre update");
        genreService.update(genre1);
        genreService.delete(genre1);
        System.out.print(genreService.getById(1));

    }


    @Test
    public void save() throws Exception {
        genreService.save(genre);
        genreService.save(genre1);
    }

    @Test
    public void update() throws Exception {
        genre1.setName("Test genre update");
        genreService.update(genre1);
    }

    @Test
    public void delete() throws Exception {
        genreService.delete(genre1);
    }

    @Test
    public void getById() throws Exception {
        System.out.print(genreService.getById(1));
    }

}