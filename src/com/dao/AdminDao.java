package com.dao;

import com.entity.AdminPublished;
import com.entity.User;

import java.util.List;

public interface AdminDao {
    //管理员查看管理已发布
    List<AdminPublished> adminPbMsg();
    void banPbMsg(int car_id);
    List<User> manageVip();
    void closeDaoVip(int user_id);
}
