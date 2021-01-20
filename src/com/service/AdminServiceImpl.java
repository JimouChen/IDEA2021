package com.service;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.entity.AdminPublished;
import com.entity.User;

import java.util.List;

public class AdminServiceImpl implements AdminService{
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public List<AdminPublished> adminPbMsg() {
        return adminDao.adminPbMsg();
    }

    @Override
    public void banPbMsg(int car_id) {
        adminDao.banPbMsg(car_id);
    }

    @Override
    public List<User> manageVip() {
        return adminDao.manageVip();
    }

    @Override
    public void closeDaoVip(int user_id) {
        adminDao.closeDaoVip(user_id);
    }
}
