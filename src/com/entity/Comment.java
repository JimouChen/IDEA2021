package com.entity;

public class Comment {
    int carId;
    String carMsg;
    String comm;
    int comManId;
    int selfUid;
    String comManName;

    public Comment() {
    }

    public Comment(int carId, String carMsg, String comm, int comManId, int selfUid, String comManName) {
        this.carId = carId;
        this.carMsg = carMsg;
        this.comm = comm;
        this.comManId = comManId;
        this.selfUid = selfUid;
        this.comManName = comManName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarMsg() {
        return carMsg;
    }

    public void setCarMsg(String carMsg) {
        this.carMsg = carMsg;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public int getComManId() {
        return comManId;
    }

    public void setComManId(int comManId) {
        this.comManId = comManId;
    }

    public int getSelfUid() {
        return selfUid;
    }

    public void setSelfUid(int selfUid) {
        this.selfUid = selfUid;
    }

    public String getComManName() {
        return comManName;
    }

    public void setComManName(String comManName) {
        this.comManName = comManName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "carId=" + carId +
                ", carMsg='" + carMsg + '\'' +
                ", comm='" + comm + '\'' +
                ", comManId=" + comManId +
                ", selfUid=" + selfUid +
                ", comManName='" + comManName + '\'' +
                '}';
    }
}
