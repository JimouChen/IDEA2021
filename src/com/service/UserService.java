package com.service;

import com.entity.*;

import java.util.List;

public interface UserService {
    List<User> showUserMsg();

    boolean showOneUser(int user_id, String password);

    boolean registerUser(int user_id, String name, String password);

    List<CarMsg> showSelfCarMsg(int user_id);

    List<CarMsg> showPublishedCarMsg(int user_id);

    void updateCarMsg(int car_id, String newMsg, double newPrice);

    void publishCar(int car_id);

    void addNewCar(int user_id, String msg, double price);

    List<OtherCarsMsg> queryOtherCar(int user_id);

    void insertComment(int car_id, int user_id, String comment);

    public List<Comment> queryComment(int user_id);

    public void ansComment(int car_id, int user_id, String ansCom);

    List<AnsComment> queryAnsCom(int user_id);

    public void closeComment(int car_id);

    void changeUserMassage(int user_id, String name, String psw);

}
