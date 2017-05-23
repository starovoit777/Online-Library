package com.ss.ch.dao;

import java.util.List;

/**
 * Created by Serhii Starovoit on 3/15/2017  in  3:56 PM .
 */


public interface CrudDao<E> {

    void save(E entity);

    void update(E entity);

    void delete(E entity);

    E getById(int id);

    List<E> getAll();


}