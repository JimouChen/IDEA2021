package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean showOneUser(int user_id, String password) {
        return userDao.getOneUser(user_id, password);
    }

    @Override
    public List<User> showUserMsg() {
        return userDao.getAllUser();
    }

    @Override
    public boolean registerUser(int user_id, String name, String password) {
        return userDao.register(user_id, name, password);
    }
}
