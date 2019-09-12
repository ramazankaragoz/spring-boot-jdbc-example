package com.example.springbootjdbcexample.service;

import java.util.List;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public interface BaseService<T,ID> {

    T save(T t);
    T update(T t);
    List<T> findAll();
    T findById(ID id);
    void deleteById(ID id);
    void delete(T t);

}
