package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.*;

import java.util.List;

public class UserServiceImpl implements UserService {
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

    @Override
    public void insertComment(int car_id, int user_id, String comment) {
        userDao.insertComment(car_id, user_id, comment);
    }

    @Override
    public List<Comment> queryComment(int user_id) {
        return userDao.queryComment(user_id);
    }

    @Override
    public void ansComment(int car_id, int user_id, String ansCom) {
        userDao.ansComment(car_id, user_id, ansCom);
    }

    @Override
    public List<AnsComment> queryAnsCom(int user_id) {
        return userDao.queryAnsCom(user_id);
    }

    @Override
    public void closeComment(int car_id) {
        userDao.closeComment(car_id);
    }

    @Override
    public void changeUserMassage(int user_id, String name, String psw) {
        userDao.changeUserMassage(user_id, name, psw);
    }
}
