package com.example.springbootjdbcexample.dto;

import java.util.Collection;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public class UserDTO extends BaseDTO<Long> {

    private Long userName;

    private String password;

    private String firstName;

    private String lastName;

    private Collection<RoleDTO> roles;

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleDTO> roles) {
        this.roles = roles;
    }
}
