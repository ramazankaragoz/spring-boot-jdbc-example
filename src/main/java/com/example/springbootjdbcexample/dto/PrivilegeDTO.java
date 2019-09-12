package com.example.springbootjdbcexample.dto;

/**
 * @author Ramazan Karagöz
 * @date 9/12/2019
 */

public class PrivilegeDTO extends BaseDTO<Long> {

    private String privilegeName;

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }
}
