package com.dao;

import com.entity.*;
import com.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAllUser() {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, `name`, psw, vip from `user`;";

        try {
            connection = DBUtil.getConnection();
            preparedstatement = connection.prepareStatement(sql);
            resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {
                int uid = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String psw = resultSet.getString("psw");
                int vip = resultSet.getInt("vip");

                users.add(new User(uid, name, psw, vip));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedstatement, connection);
        }

        return users;
    }

    @Override
    public boolean register(int user_id, String name, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * from `user` where `user_id` =" + user_id + ";";
        boolean registerFlag = false;

        try {//先看看有没有已经注册过的账号
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) registerFlag = false;
            else {
                registerFlag = true;
                String registerSql = "insert into `user` values (?,?,?,1);";
                queryRunner.update(connection, registerSql, user_id, name, password);//注册即为vip
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);

        }
        return registerFlag;
    }

    @Override
    public boolean getOneUser(int user_id, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean loginFlag = false;
        String sql = "SELECT psw from `user` where `user_id` = " + user_id + ";";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String psw = resultSet.getString("psw");
                if (psw.equals(password)) {
                    loginFlag = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
        return loginFlag;
    }

    @Override
    public List<CarMsg> showSelfCar(int user_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CarMsg> carMsg = new ArrayList<>();
        String sql = "SELECT car_id, car.user_id, car.msg as '汽车信息',car.price as '价格', `user`.`name` as '车主', car.publish as '发布状态', close_com, ban from car, `user` where car.ban = 0 and `user`.user_id = car.user_id and car.publish = 0 and `user`.user_id = " + user_id + ";";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int car_id = resultSet.getInt("car_id");
                String msg = resultSet.getString("汽车信息");
                double price = resultSet.getDouble("价格");
                String uname = resultSet.getString("车主");
                int publish = resultSet.getInt("发布状态");
                String publishMsg = "";
                if (publish == 0) publishMsg = "未发布";
                else publishMsg = "已发布";
                int close_com = resultSet.getInt("close_com");
                int ban = resultSet.getInt("ban");

                carMsg.add(new CarMsg(car_id, user_id, msg, price, uname, publishMsg, close_com, ban));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
        return carMsg;
    }

    @Override
    public List<CarMsg> queryPublishedCar(int user_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CarMsg> carMsg = new ArrayList<>();
        String sql = "SELECT car_id, car.user_id, car.msg as '汽车信息',car.price as '价格', `user`.`name` as '车主', car.publish as '发布状态', close_com, ban from car, `user` where `user`.user_id = car.user_id and car.publish = 1 and car.ban = 0 and `user`.user_id = " + user_id + ";";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int car_id = resultSet.getInt("car_id");
                String msg = resultSet.getString("汽车信息");
                double price = resultSet.getDouble("价格");
                String uname = resultSet.getString("车主");
                int publish = resultSet.getInt("发布状态");
                String publishMsg = "";
                if (publish == 0) publishMsg = "未发布";
                else publishMsg = "已发布";
                int close_com = resultSet.getInt("close_com");
                int ban = resultSet.getInt("ban");

                carMsg.add(new CarMsg(car_id, user_id, msg, price, uname, publishMsg, close_com, ban));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
        return carMsg;
    }

    @Override
    public void daoUpdateCar(int car_id, String newMsg, double newPrice) {
        Connection connection = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE car SET msg = ?, price = ? where car_id = ?;";

        try {
            connection = DBUtil.getConnection();
            queryRunner.update(connection, sql, newMsg, newPrice, car_id);
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void daoPublish(int car_id) {
        Connection connection = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE car SET publish=1 where car_id = ?;";

        try {
            connection = DBUtil.getConnection();
            queryRunner.update(connection, sql, car_id);
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCar(int user_id, String msg, double price) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql1 = "SELECT COUNT(car_id) as 'num' from car;";
        String sql2 = "INSERT INTO car VALUES (?, ?, ?, ?, 0, 0, 0);\n";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("num");
                queryRunner.update(connection, sql2, count + 1, user_id, msg, price);
            }

            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public List<OtherCarsMsg> lookOtherCar(int user_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<OtherCarsMsg> otherCarsMsg = new ArrayList<>();
        String sql = "SELECT car.car_id, car.msg as'汽车信息',car.price'价格', `user`.`name`'车主' from car, `user` where `user`.user_id = car.user_id and car.publish = 1  and car.close_com = 0  and car.ban = 0\n" +
                "and `user`.user_id !=" + user_id + " ;";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int car_id = resultSet.getInt("car_id");
                String msg = resultSet.getString("汽车信息");
                String owner = resultSet.getString("车主");
                double price = resultSet.getDouble("价格");
                otherCarsMsg.add(new OtherCarsMsg(car_id, msg, price, owner));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }

        return otherCarsMsg;
    }

    public void insertComment(int car_id, int user_id, String comment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql1 = "SELECT COUNT(com_id) as 'num' from `comment`;";
        String sql2 = "INSERT INTO `comment` VALUES (?, ?, ?, ?, 1);";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int count = resultSet.getInt("num");
                System.out.println(count + car_id + comment + user_id);
                queryRunner.update(connection, sql2, count + 1, car_id, comment, user_id);
            }

            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public List<Comment> queryComment(int user_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT car.car_id'cid', car.msg'车信息', `comment`.com_text'评论', `user`.user_id'留言人账号', car.user_id'自己账号', `user`.`name`'留言人' from car, `user`, `comment` where car.car_id = `comment`.car_id and `comment`.user_id = `user`.user_id and car.user_id = " + user_id + " ;";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int carId = resultSet.getInt("cid");
                String msg = resultSet.getString("车信息");
                String com_text = resultSet.getString("评论");
                int comManId = resultSet.getInt("留言人账号");
                int selfUid = resultSet.getInt("自己账号");
                String comManName = resultSet.getString("留言人");

                comments.add(new Comment(carId, msg, com_text, comManId, selfUid, comManName));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
        return comments;
    }

    @Override
    public void ansComment(int car_id, int user_id, String ansCom) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql1 = "SELECT COUNT(ans_id) as 'num' from `answer`;";
        String sql2 = "INSERT INTO `answer` VALUES (?, ?, ?, ?, 1);";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("num");
                System.out.println(count + car_id + ansCom + user_id);
                queryRunner.update(connection, sql2, count + 1, car_id, ansCom, user_id);
            }

            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public List<AnsComment> queryAnsCom(int user_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AnsComment> ansComments = new ArrayList<>();
        String sql = "SELECT car.msg'汽车信息', car.price'价格', `user`.`name`'留言者', `comment`.com_text'留言内容', answer.com_text'我的回复' from `user`, car, `comment`, answer\n" +
                "where car.car_id = `comment`.car_id and `comment`.car_id = answer.car_id\n" +
                "and `comment`.user_id = `user`.user_id and answer.user_id = " + user_id + " ;";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String msg = resultSet.getString("汽车信息");
                double price = resultSet.getDouble("价格");
                String comName = resultSet.getString("留言者");
                String comment = resultSet.getString("留言内容");
                String myAnsCom = resultSet.getString("我的回复");

                ansComments.add(new AnsComment(msg, price, comName, comment, myAnsCom));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }

        return ansComments;
    }
}