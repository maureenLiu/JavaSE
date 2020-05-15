package com.maureen.net.v4.client;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -2560684537607454574L;
    private String username;
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
