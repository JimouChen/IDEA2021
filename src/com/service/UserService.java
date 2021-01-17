package com.service;

import com.entity.CarMsg;
import com.entity.OtherCarsMsg;
import com.entity.User;

import java.util.List;

public interface UserService {
    List<User> showUserMsg();
    boolean showOneUser(int user_id, String password);
    boolean registerUser(int user_id, String name, String password);
    List<CarMsg> showSelfCarMsg(int user_id);
    List<CarMsg> showPublishedCarMsg(int user_id);
    void updateCarMsg(int car_id, String newMsg, double newPrice);
    void publishCar(int car_id);
    void addNewCar( int user_id, String msg, double price);
    List<OtherCarsMsg> queryOtherCar(int user_id);
}
