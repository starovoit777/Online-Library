package com.ss.ch.service.impl;

import com.ss.ch.dao.CommentDao;
import com.ss.ch.domain.Comment;
import com.ss.ch.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public void save(Comment entity) {
        commentDao.save(entity);
    }

    public void update(Comment entity) {
        commentDao.update(entity);
    }

    public void delete(Comment entity) {
        commentDao.delete(entity);
    }

    public Comment getById(int id) {
        return  commentDao.getById(id);
    }
}
