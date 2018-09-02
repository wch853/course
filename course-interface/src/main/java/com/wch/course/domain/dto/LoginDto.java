package com.wch.course.domain.dto;

public class LoginDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户token
     */
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
