package com.example.springbootjdbcexample.dao;

import java.util.List;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public interface CrudDAO<T,ID> {

    T save(T t);

    T getById(ID id);

    List<T> findAll();
}
