package com.dao;

import com.entity.User;
import com.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}