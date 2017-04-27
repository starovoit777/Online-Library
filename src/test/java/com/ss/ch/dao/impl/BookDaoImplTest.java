package com.ss.ch.dao.impl;

import com.ss.ch.dao.BookDao;
import com.ss.ch.domain.Book;
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
public class BookDaoImplTest {


    @Autowired
    private BookDao bookDao;

    Book book ;


    @Before
    public void init() throws Exception {
        book = new Book();
        book.setTitle("TestDao title1");
        book.setDescription("TestDao description1");
        book.setDownloadCounter(2);
        book.setRating(StarRating.NO_STARS);
        book.setUrlPicture("TestDao urlPicture1");
    }


    @Test
    public void crud() throws Exception {
        bookDao.save(book);
        book.setTitle("TestDao title update");
        bookDao.update(book);
        System.out.println(bookDao.getById(1).getTitle());
        bookDao.delete(book);

    }


    @Test
    public void save() throws Exception {
        bookDao.save(book);
    }

    @Test
    public void update() throws Exception {
        book.setTitle("TestDao title update");
        bookDao.update(book);
    }

    @Test
    public void delete() throws Exception {
        bookDao.delete(book);
    }

    @Test
    public void getById() throws Exception {
        System.out.println(bookDao.getById(1).getTitle());
    }

}