package com.ss.ch.dao;

import com.ss.ch.domain.User;

import java.util.List;

/**
 * Created by Micro on 4/24/2017.
 */
public interface UserDao extends CrudDao<User> {

    List<User> findAllUsers();
}
