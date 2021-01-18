package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.CarMsg;
import com.entity.OtherCarsMsg;
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

    @Override
    public List<CarMsg> showSelfCarMsg(int user_id) {
         return userDao.showSelfCar(user_id);
    }

    @Override
    public List<CarMsg> showPublishedCarMsg(int user_id) {
        return userDao.queryPublishedCar(user_id);
    }

    @Override
    public void updateCarMsg(int car_id, String newMsg, double newPrice) {
        userDao.daoUpdateCar(car_id, newMsg, newPrice);
    }

    @Override
    public void publishCar(int car_id) {
        userDao.daoPublish(car_id);
    }

    @Override
    public void addNewCar(int user_id, String msg, double price) {
        userDao.addCar(user_id, msg, price);
    }

    @Override
    public List<OtherCarsMsg> queryOtherCar(int user_id) {
        return userDao.lookOtherCar(user_id);
    }

    public void insertComment(int car_id, int user_id, String comment){
        userDao.insertComment(car_id, user_id, comment);
    }
}
