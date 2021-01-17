package com.entity;

public class OtherCarsMsg {
    String msg;
    double price;
    String carOwner;

    public OtherCarsMsg() {
    }

    public OtherCarsMsg(String msg, double price, String carOwner) {
        this.msg = msg;
        this.price = price;
        this.carOwner = carOwner;
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

    @Override
    public String toString() {
        return "OtherCarsMsg{" +
                "msg='" + msg + '\'' +
                ", price=" + price +
                ", carOwner='" + carOwner + '\'' +
                '}';
    }
}
