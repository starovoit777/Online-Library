package com.ss.ch.service.impl;

import com.ss.ch.domain.Author;
import com.ss.ch.domain.StarRating;
import com.ss.ch.service.AuthorService;
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
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class AuthorServiceImplTest {


    @Autowired
    private AuthorService genreService;


    Author author;



    @Before
    public void init() throws Exception {
        author.setName("Test Service name 1");
        author.setSurname("Test Service surname 1");
        author.setPenName("Test Service penName 1");
        author.setDescription("Test Service description 1");
        author.setRating(StarRating.ONE_STARS);
        author.setUrlPicture("Test name Service 1");
    }


    @Test
    public void crud() throws Exception {
        genreService.save(author);
        author.setName("TestService name update");
        genreService.update(author);
        System.out.println(genreService.getById(1).getName());
        genreService.delete(author);

    }



    @Test
    public void save() throws Exception {
        genreService.save(author);
    }

    @Test
    public void update() throws Exception {
        author.setName("TestService name update");
        genreService.update(author);
    }

    @Test
    public void delete() throws Exception {
        genreService.delete(author);
    }

    @Test
    public void getById() throws Exception {
        System.out.println(genreService.getById(1).getName());
    }

}