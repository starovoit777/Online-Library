package com.ss.ch.dao.impl;

import com.ss.ch.dao.AuthorDao;
import com.ss.ch.domain.Author;
import com.ss.ch.domain.StarRating;
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
public class AuthorDaoImplTest {


    @Autowired
    private AuthorDao authorDao;

    Author author;

    @Before
    public void init() throws Exception {
        author = new Author();
        author.setName("Test name ");
        author.setSurname("Test surname ");
        author.setPenName("Test penName ");
        author.setDescription("Test description ");
        author.setRating(StarRating.ONE_STARS);
        author.setUrlPicture("Test urlPicture ");
    }


    @Test
    public void crud() throws Exception {
        authorDao.save(author);
        author.setName("Test name update");
        authorDao.update(author);
        System.out.println(authorDao.getById(1).getName());
        authorDao.delete(author);

    }


    @Test
    public void save() throws Exception {
        authorDao.save(author);
    }

    @Test
    public void update() throws Exception {
        author.setName("Test name update");
        authorDao.update(author);
    }

    @Test
    public void delete() throws Exception {
        authorDao.delete(author);
    }

    @Test
    public void getById() throws Exception {
        System.out.println(authorDao.getById(1).getName());
    }

}