package com.dao;

import com.entity.Comment;
import com.entity.AdminPublished;
import com.entity.User;
import com.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public List<AdminPublished> adminPbMsg() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AdminPublished> adminPublished = new ArrayList<>();
        String sql = "SELECT car.car_id, `user`.`name`'发布者', car.msg'汽车信息', car.price'价格' from car, `user` where car.ban = 0 and car.publish = 1 and car.close_com = 0 and `user`.user_id = car.user_id;";


        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int carId = resultSet.getInt("car_id");
                String name = resultSet.getString("发布者");
                String msg = resultSet.getString("汽车信息");
                double price = resultSet.getDouble("价格");
                adminPublished.add(new AdminPublished(carId, name, msg, price));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
        return adminPublished;
    }

    @Override
    public void banPbMsg(int car_id) {
        Connection connection = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE `car` SET `ban` = 1 where car_id = ?;";

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
    public List<User> manageVip() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        String sql = "SELECT `user`.user_id'会员账号', `user`.psw, `user`.`name`'会员名称', `user`.vip from `user` where `user`.vip = 1;";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("会员账号");
                String psw = resultSet.getString("psw");
                String name = resultSet.getString("会员名称");
                int vip = resultSet.getInt("vip");
                users.add(new User(userId, name, psw, vip));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseSource1(resultSet, preparedStatement, connection);
        }
        return users;
    }

    @Override
    public void closeDaoVip(int user_id) {
        Connection connection = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE `user` SET `vip` = 0 where user_id = ?;";

        try {
            connection = DBUtil.getConnection();
            queryRunner.update(connection, sql, user_id);
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
