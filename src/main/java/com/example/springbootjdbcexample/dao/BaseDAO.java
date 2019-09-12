package com.example.springbootjdbcexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public abstract class BaseDAO<T> implements Serializable{

    private Class<T> dtoClass;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BaseDAO() {
        dtoClass= (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),BaseDAO.class);
    }

    public Integer save(String sql,Object... parameters){
        return jdbcTemplate.update(sql,parameters);
    }

    public T getById(String sql,Long id){
        return null;
    }

    public List<T> findAll(String sql){
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(dtoClass));
    }

    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
