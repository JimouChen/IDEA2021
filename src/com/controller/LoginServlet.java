package com.controller;

import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.enter")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
    }

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

    protected void getAllUsersMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        List<User> users = userService.showUserMsg();
        for (User each :
                users) {
            response.getWriter().println(each.toString());
        }
        System.out.println(users);
    }

    protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        int user_id = Integer.parseInt(request.getParameter("uid"));

        String password = request.getParameter("password");
        System.out.println(user_id);
        System.out.println(password);
        Boolean flag = userService.showOneUser(user_id, password);

        if (flag){//登陆成功
            System.out.println("登陆成功");
            //把账号放到session
            HttpSession session = request.getSession();
            session.setAttribute("userid", user_id);
            request.getRequestDispatcher("/Pages/userBackstage.jsp").forward(request, response);
        }else {//登陆失败
            request.setAttribute("Massage", "账号或者密码输入有误或者输入为空，请重新输入");
            request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
        }
    }

    protected void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int user_id = Integer.parseInt(request.getParameter("aid"));
        String password = request.getParameter("password");
        System.out.println(user_id);
        System.out.println(password);

        if (user_id == 1 && password.equals("admin")){//登陆成功
            System.out.println("登陆成功");
            request.getRequestDispatcher("/Pages/adminBackstage.jsp").forward(request, response);
        }else {//登陆失败
            request.setAttribute("Massage", "账号或者密码输入有误或者输入为空，请重新输入");
            request.getRequestDispatcher("/Pages/adminLogin.jsp").forward(request, response);
        }
    }


}
