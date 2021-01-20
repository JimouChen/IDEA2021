package com.entity;

public class AnsComment {
    String carMsg;
    double price;
    String comName;
    String comment;
    String myAnsCom;

    public AnsComment() {
    }

    public AnsComment(String carMsg, double price, String comName, String comment, String myAnsCom) {
        this.carMsg = carMsg;
        this.price = price;
        this.comName = comName;
        this.comment = comment;
        this.myAnsCom = myAnsCom;
    }

    public String getCarMsg() {
        return carMsg;
    }

    public void setCarMsg(String carMsg) {
        this.carMsg = carMsg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMyAnsCom() {
        return myAnsCom;
    }

    public void setMyAnsCom(String myAnsCom) {
        this.myAnsCom = myAnsCom;
    }

    @Override
    public String toString() {
        return "AnsComment{" +
                "ansCom='" + carMsg + '\'' +
                ", price=" + price +
                ", comName='" + comName + '\'' +
                ", comment='" + comment + '\'' +
                ", myAnsCom='" + myAnsCom + '\'' +
                '}';
    }
}
