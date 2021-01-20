package com.controller;

import com.entity.CarMsg;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/update.do")
public class CarMsgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<CarMsg> carMsg = userService.showSelfCarMsg((user_id));
        request.setAttribute("selfCarMsg", carMsg);
        request.getRequestDispatcher("/Pages/saleInfo.jsp").forward(request, response);
    }
}
