package com.controller;

import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        int uid = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("username");
        String psw = request.getParameter("password");
        System.out.println(uid+name+psw);
        if (userService.registerUser(uid, name, psw)) {
            //注册成功
            System.out.println("注册成功");
            request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
        } else {
            System.out.println("注册失败");
            request.setAttribute("registerMassage", "注册失败，请重新注册");
            request.getRequestDispatcher("/Pages/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
