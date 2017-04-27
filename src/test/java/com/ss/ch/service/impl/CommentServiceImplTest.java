package com.ss.ch.service.impl;

import com.ss.ch.domain.Comment;
import com.ss.ch.service.CommentService;
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
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    Comment comment;

    @Before
    public void init() throws Exception {
        comment = new Comment();
        comment.setCreatedDate(new Date());
        comment.setComment("Test Service comment");
    }

    @Test
    public void crud() throws Exception {
        commentService.save(comment);
        comment.setComment("Test Service comment update");
        commentService.update(comment);
        System.out.print(commentService.getById(1));
        commentService.delete(comment);

    }


    @Test
    public void save() throws Exception {
        commentService.save(comment);
    }

    @Test
    public void update() throws Exception {
        comment.setComment("Test Service comment update");
        commentService.update(comment);
    }

    @Test
    public void delete() throws Exception {
        commentService.delete(comment);
    }

    @Test
    public void getById() throws Exception {
        System.out.print(commentService.getById(1));
    }

}