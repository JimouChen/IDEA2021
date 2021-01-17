package com.dao;

import com.entity.CarMsg;
import com.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    boolean getOneUser(int user_id, String password);
    boolean register(int user_id, String name, String password);
    List<CarMsg> showSelfCar(int user_id);//用于查看自己车信息
    List<CarMsg> queryPublishedCar(int user_id);//用于查看自己已经发布的车信息
    void daoUpdateCar(int car_id, String newMsg, double newPrice);//编辑未发布的车的信息
    void daoPublish(int car_id);//发布二手车


}
