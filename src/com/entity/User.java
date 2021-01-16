package com.entity;

public class User {
    int userId;
    String name;
    String password;
    int vip;

    public User() {
    }

    public User(int userId, String name, String password, int vip) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.vip = vip;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", vip=" + vip +
                '}';
    }
}
