package com.company.objects;

public class Password {

    private String username;
    private String password;
    private String role;

    public Password(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public Password() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
