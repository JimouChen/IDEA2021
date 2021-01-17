package com.dao;

import com.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    boolean getOneUser(int user_id, String password);
    boolean register(int user_id, String name, String password);
}
