package com.ss.ch.dao.impl;

import com.ss.ch.dao.CommentDao;
import com.ss.ch.domain.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Micro on 4/24/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CommentDaoImplTest {

    @Autowired
    private CommentDao commentDao;

    Comment comment;

    @Before
    public void init() throws Exception {
        comment = new Comment();
        comment.setCreatedDate(new Date());
        comment.setComment("Test comment");
    }


    @Test
    public void crud() throws Exception {
        commentDao.save(comment);
        comment.setComment("Test comment update");
        commentDao.update(comment);
        System.out.print(commentDao.getById(1));
        commentDao.delete(comment);

    }


    @Test
    public void save() throws Exception {
        commentDao.save(comment);
    }

    @Test
    public void update() throws Exception {
        comment.setComment("Test comment update");
        commentDao.update(comment);
    }

    @Test
    public void delete() throws Exception {
        commentDao.delete(comment);
    }

    @Test
    public void getById() throws Exception {
        System.out.print(commentDao.getById(1));
    }

}