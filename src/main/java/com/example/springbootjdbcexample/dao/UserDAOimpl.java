package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.dto.UserDTO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

        Integer status=null;

        try {
            queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO ");
            queryBuilder.append("usr_user (user_name,first_name,last_name,password) ");
            queryBuilder.append("VALUES");
            queryBuilder.append("(:userName,:firstName,:lastName,:password)");

            //params = new Object[]{userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPassword()};

            Map<String,Object> parameters=new HashMap<>();
            parameters.put("userName",userDTO.getUserName());
            parameters.put("firstName",userDTO.getFirstName());
            parameters.put("lastName",userDTO.getLastName());
            parameters.put("password",userDTO.getPassword());


            status = save(queryBuilder.toString(), parameters);

            //getJdbcTemplate().getDataSource().getConnection().commit();

            //params = new Object[]{userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastName(), null};
            //save(queryBuilder.toString(), params);

            //getJdbcTemplate().getDataSource().getConnection().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }


        if (status != null) {
            userDTO.setId(status.longValue());
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

        List<UserDTO> userDTOS = findAll(queryBuilder.toString());

        return userDTOS;
    }
}
