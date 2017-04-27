package com.ss.ch.service.impl;

import com.ss.ch.domain.Book;
import com.ss.ch.domain.StarRating;
import com.ss.ch.service.BookService;
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
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    Book book;


    @Before
    public void init() throws Exception {
        book = new Book();
        book.setTitle("TestService title1");
        book.setDescription("TestService description1");
        book.setDownloadCounter(2);
        book.setRating(StarRating.NO_STARS);
        book.setUrlPicture("TestService urlPicture1");
    }


    @Test
    public void crud() throws Exception {
        bookService.save(book);
        book.setTitle("TestService title update");
        bookService.update(book);
        System.out.println(bookService.getById(1).getTitle());
        bookService.delete(book);

    }


    @Test
    public void save() throws Exception {
        bookService.save(book);
    }

    @Test
    public void update() throws Exception {
        book.setTitle("TestService title update");
        bookService.update(book);
    }

    @Test
    public void delete() throws Exception {
        bookService.delete(book);
    }

    @Test
    public void getById() throws Exception {
        System.out.println(bookService.getById(1).getTitle());
    }

}