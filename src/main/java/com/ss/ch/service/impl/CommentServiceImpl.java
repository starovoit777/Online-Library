package com.ss.ch.service.impl;

import com.ss.ch.dao.CommentDao;
import com.ss.ch.domain.Comment;
import com.ss.ch.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void save(Comment entity) {
        commentDao.save(entity);
    }

    @Override
    public void update(Comment entity) {
        commentDao.update(entity);
    }

    @Override
    public void delete(Comment entity) {
        commentDao.delete(entity);
    }

    @Override
    public Comment getById(int id) {
        return commentDao.getById(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentDao.getAll();
    }
}
