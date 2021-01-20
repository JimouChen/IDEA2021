package com.service;

import com.entity.AdminPublished;
import com.entity.User;

import java.util.List;

public interface AdminService {
    List<AdminPublished> adminPbMsg();
    void banPbMsg(int car_id);
    List<User> manageVip();
    void closeDaoVip(int user_id);
}
