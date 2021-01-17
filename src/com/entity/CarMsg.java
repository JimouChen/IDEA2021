package com.entity;

public class CarMsg {
    int car_id;
    int user_id;
    String msg;
    double price;
    String carOwner;
    String publish;
    int isCloseCom;
    int isBan;

    public CarMsg() {
    }

    public CarMsg(int car_id, int user_id, String msg, double price, String carOwner, String publish, int isCloseCom, int isBan) {
        this.car_id = car_id;
        this.user_id = user_id;
        this.msg = msg;
        this.price = price;
        this.carOwner = carOwner;
        this.publish = publish;
        this.isCloseCom = isCloseCom;
        this.isBan = isBan;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getIsCloseCom() {
        return isCloseCom;
    }

    public void setIsCloseCom(int isCloseCom) {
        this.isCloseCom = isCloseCom;
    }

    public int getIsBan() {
        return isBan;
    }

    public void setIsBan(int isBan) {
        this.isBan = isBan;
    }

    @Override
    public String toString() {
        return "CarMsg{" +
                "car_id=" + car_id +
                ", user_id=" + user_id +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                ", carOwner='" + carOwner + '\'' +
                ", publish='" + publish + '\'' +
                ", isCloseCom=" + isCloseCom +
                ", isBan=" + isBan +
                '}';
    }
}
