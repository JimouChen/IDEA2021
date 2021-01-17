package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    List<User> showUserMsg();
    boolean showOneUser(int user_id, String password);
    boolean registerUser(int user_id, String name, String password);
}
