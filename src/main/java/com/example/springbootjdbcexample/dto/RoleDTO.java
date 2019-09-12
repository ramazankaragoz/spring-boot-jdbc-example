package com.example.springbootjdbcexample.dto;

import java.util.Collection;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public class RoleDTO extends BaseDTO<Long> {

    private String roleName;

    private Collection<PrivilegeDTO> privileges;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<PrivilegeDTO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<PrivilegeDTO> privileges) {
        this.privileges = privileges;
    }
}
