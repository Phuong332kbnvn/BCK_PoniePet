package com.example.bck_poniepet.Objects;

public class Account {
    String fullName,username,email,password,rePassword;

    public Account() {
    }

    public Account(String fullName, String username, String email, String password, String rePassword) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
