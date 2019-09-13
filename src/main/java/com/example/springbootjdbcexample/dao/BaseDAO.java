package com.example.springbootjdbcexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public abstract class BaseDAO<T> implements Serializable{

    private Class<T> dtoClass;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private GeneratedKeyHolder generatedKeyHolder;

    public BaseDAO() {
        generatedKeyHolder=new GeneratedKeyHolder();
        dtoClass= (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),BaseDAO.class);
    }

    public Integer save(String sql, Map<String,Object> parameters){


        SqlParameterSource namedParameters = new MapSqlParameterSource().addValues(parameters);

        namedParameterJdbcTemplate.update(sql,namedParameters,generatedKeyHolder,new String[]{"id"});

        return generatedKeyHolder.getKey().intValue();
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
