package com.controller;

import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("*.car")
public class UserOperateServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1, servletPath.length() - 4);
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

    protected void updateMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        HttpSession session = request.getSession();
        session.setAttribute("carId", carId);
        request.getRequestDispatcher("/Pages/changeCarMsg.jsp").forward(request, response);

    }

    protected void receiveNewMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int carId = (int) session.getAttribute("carId");
        //页面得到的车信息和价格
        String msg = request.getParameter("carMsg");
        double price = Double.parseDouble(request.getParameter("money"));
        userService.updateCarMsg(carId, msg, price);
//        System.out.println(msg + "  " + price);
        request.getRequestDispatcher("/Pages/userBackstage.jsp").forward(request, response);
    }

    protected void publishNewCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        userService.publishCar(carId);
        request.getRequestDispatcher("/Pages/publishSuccessful.jsp").forward(request, response);
        System.out.println("发布成功");
    }
}
