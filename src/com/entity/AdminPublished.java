package com.entity;

public class AdminPublished {
    int carId;
    String username;
    String msg;
    double price;

    public AdminPublished() {
    }

    public AdminPublished(int carId, String username, String msg, double price) {
        this.carId = carId;
        this.username = username;
        this.msg = msg;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "adminPublished{" +
                "carId=" + carId +
                ", username='" + username + '\'' +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                '}';
    }
}
