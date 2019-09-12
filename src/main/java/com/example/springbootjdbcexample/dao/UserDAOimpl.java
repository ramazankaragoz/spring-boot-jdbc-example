package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.dto.UserDTO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

@Repository
public class UserDAOimpl extends BaseDAO<UserDTO> implements UserDAO {

    private StringBuilder queryBuilder;
    private MapSqlParameterSource parameters;
    private Object[] params;

    @Override
    public UserDTO save(UserDTO userDTO) {

        queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO ");
        queryBuilder.append("usr_user (user_name,first_name,last_name,password) ");
        queryBuilder.append("VALUES");
        queryBuilder.append("(?,?,?,?)");

        params = new Object[]{userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPassword()};

        Integer status = save(queryBuilder.toString(), params);

        if (status != 1) {
            return null;
        }

        return userDTO;
    }

    @Override
    public UserDTO getById(Long aLong) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT id, user_name,last_name,first_name, password FROM usr_user");

        List<UserDTO> userDTOS=findAll(queryBuilder.toString());

        return userDTOS;
    }
}
