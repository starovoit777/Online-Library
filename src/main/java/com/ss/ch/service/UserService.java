package com.ss.ch.service;

import com.ss.ch.domain.User;

import java.util.List;

/**
 * Created by Micro on 4/23/2017.
 */
public interface UserService extends CrudService<User> {
    List<User> findAllUsers();
}
