package com.ss.ch.service.impl;

import com.ss.ch.dao.UserDao;
import com.ss.ch.domain.User;
import com.ss.ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    public void save(User entity) {
        userDao.save(entity);
    }

    public void update(User entity) {
        userDao.update(entity);
    }

    public void delete(User entity) {
        userDao.delete(entity);
    }

    public User getById(int id) {
        return  userDao.getById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return  userDao.findAllUsers();
    }
}
