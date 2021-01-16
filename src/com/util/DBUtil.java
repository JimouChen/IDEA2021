package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBUtil {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/car_market?serverTimezone=Hongkong";
        String user = "root";
        String password = "admin";
        String driverName = "com.mysql.jdbc.Driver";
        Connection conn = null;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void releaseSource(Statement statement, Connection connection) {
        try {
            if (statement != null)
                statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void releaseSource1(ResultSet rs, Statement statement, Connection connection) {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (statement != null)
                statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}