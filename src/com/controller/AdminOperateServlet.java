package com.controller;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.entity.AdminPublished;
import com.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.admin")
public class AdminOperateServlet extends HttpServlet {
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1, servletPath.length() - 6);
        System.out.println(methodName);
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void banPublish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AdminPublished> adminPublished = adminDao.adminPbMsg();
        request.setAttribute("AdminPbMsg", adminPublished);
        request.getRequestDispatcher("/Pages/adminManagePower.jsp").forward(request, response);
    }

    //set ban = 1
    protected void banUserPb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        adminDao.banPbMsg(carId);
        banPublish(request, response);
    }

    //set vip = 0
    protected void manageVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = adminDao.manageVip();
        request.setAttribute("userVip", users);
        request.getRequestDispatcher("/Pages/adminVip.jsp").forward(request, response);
    }

    protected void closeVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        adminDao.closeDaoVip(userId);
        manageVip(request, response);
    }
}
